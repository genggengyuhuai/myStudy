package algorithm.school_hire_2019.vivo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 类似背包，但不只重量一个条件，用递归做的
 * @author lihaoyu
 * @date 3/5/2020 9:48 PM
 */
public class Main3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        String[] input = inputStr.split(" ");
        int totalDisk = Integer.parseInt(input[0]);
        int totalMemory = Integer.parseInt(input[1]);
        List<Service> services = parseServices(input[2].split("#"));
        int output = solution(totalDisk, totalMemory, services);
        System.out.println(output);
    }

    private static int max = 0;
    private static void fun(List<Service> services, int index, int currentDisk, int currentMemory, int currentUser){
        int leftDisk, leftMemory;
        if(index == services.size() || (leftDisk = currentDisk - services.get(index).disk ) < 0 || (leftMemory = currentMemory - services.get(index).memory ) < 0){
            return;
        }
        int sumUser = currentUser+services.get(index).users;
        max = Math.max(max, sumUser);
        for(int i = index+1; i < services.size();i++){
            fun(services,i,leftDisk,leftMemory,sumUser);
        }
    }

    private static int solution(int totalDisk, int totalMemory, List<Service> services) {
        for (int i = 0; i < services.size(); i++) {
            fun(services, i, totalDisk,totalMemory,0);
        }
        // TODO Write your code here
        return max;
    }

    private static List<Service> parseServices(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new ArrayList<Service>(0);
        }
        List<Service> services = new ArrayList<>(strArr.length);
        for (int i = 0; i < strArr.length; i++) {
            String[] serviceArr = strArr[i].split(",");
            int disk = Integer.parseInt(serviceArr[0]);
            int memory = Integer.parseInt(serviceArr[1]);
            int users = Integer.parseInt(serviceArr[2]);
            services.add(new Service(disk, memory, users));
        }
        return services;
    }

    static class Service {
        private int disk;

        private int memory;

        private int users;

        public Service(int disk, int memory, int users) {
            this.disk = disk;
            this.memory = memory;
            this.users = users;
        }

        public int getDisk() {
            return disk;
        }

        public void setDisk(int disk) {
            this.disk = disk;
        }

        public int getMemory() {
            return memory;
        }

        public void setMemory(int memory) {
            this.memory = memory;
        }

        public int getusers() {
            return users;
        }

        public void setusers(int users) {
            this.users = users;
        }
    }
}