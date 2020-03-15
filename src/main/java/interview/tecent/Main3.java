package interview.tecent;

/**
 * 实现一个函数，函数输入为一个文件路径描述的数组，函数输出为对该数组转换后形成的指定的树状结构。
 * 输入范例：
 * [
 *  "/diskC/folderA/test_file",
 *  "/diskC/folderA/sub_folderX/file1",
 *  "/diskKH/folderA/test_file",
 *  "/diskC/folderB/folderC/fileX"
 * ]
 * 对上述路径规则说明如下：
 * ·所有路径都视为绝对路径，以"/"开始，且各路径层都以一个"/"分隔，不存在"//"这种空名称的层
 * ·与电脑的文件系统的路径概念一样，树的单独各层里，同一层下的文件夹名称重复时，视为同一个文件夹
 * @author lihaoyu
 * @date 3/13/2020 8:43 PM
 */

import java.util.Set;
import java.util.TreeSet;

public class Main3 {

    // 根目录
    private static Path root = new Path("/");

    private static class Path implements Comparable<Path>{
        String pathName;
        Set<Path> childrenPath = new TreeSet<>();

        @Override
        public String toString() {
            return "Path{" +
                    "pathName='" + pathName + '\'' +
                    ", childrenPath=" + childrenPath +
                    '}';
        }

        public Path(String name){
            this.pathName = name;
        }

        public int compareTo(Path other){
            return pathName.compareTo(other.pathName);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Path path = (Path) o;
            return pathName != null ? pathName.equals(path.pathName) : path.pathName == null;
        }

        @Override
        public int hashCode() {
            return pathName != null ? pathName.hashCode() : 0;
        }
    }

    private static void fun(String[] src) {
        for (String singlePath : src) {
            String[] pathList = singlePath.split("/");
            Path curPath = root;
            for (String path : pathList) {
                //  跳过 .
                if (".".equals(path)) {
                    continue;
                }
                Path temp = new Path(path);
                // 当前目录层次不存在本path，新建加入
                if (!curPath.childrenPath.contains(path)) {
                    curPath.childrenPath.add(null);
                }
                // 进入下一层
                curPath = temp;

            }

        }
        System.out.println(root);
    }


    public static void main(String[] args) {
       String[] src = new String[]{ "/diskC/folderA/test_file",
 "/diskC/folderA/sub_folderX/file1",
 "/diskKH/folderA/test_file",
 "/diskC/folderB/folderC/fileX"};
       fun(src);
    }
}
