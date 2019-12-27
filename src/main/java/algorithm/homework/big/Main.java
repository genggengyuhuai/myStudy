package algorithm.homework.big;

/**
 * @author lihaoyu
 * @date 2019/12/26 22:28
 */
import org.w3c.dom.*;

import javax.xml.parsers.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    static LinkedHashSet<String> res;
    static String endId="";
    public static void main(String[] args){
        getLogOfModel("G:\\JavaStudy\\myStudy\\src\\main\\java\\algorithm\\homework\\big\\Model3.pnml","Model1.txt");
    }

    static void getLogOfModel(String modelFile, String logFile){
        //读取pnml文件，记录place，transition，arc
        Map<String,Node> map=new HashMap<>();

        Document document = getDocument(modelFile);
        NodeList list = document.getElementsByTagName("place");
        for (int i = 0; i < list.getLength(); i++) {
            Element element = (Element) list.item(i);
            String id=element.getAttribute("id");
            String text=element.getElementsByTagName("text").item(0).getTextContent();
            map.put(id,new Node(id,text,true));
        }
        list = document.getElementsByTagName("transition");
        for (int i = 0; i < list.getLength(); i++) {
            Element element = (Element) list.item(i);
            String id=element.getAttribute("id");
            String text=element.getElementsByTagName("text").item(0).getTextContent();
            map.put(id,new Node(id,text,false));
        }
        list = document.getElementsByTagName("arc");
        for (int i = 0; i < list.getLength(); i++) {
            Element element = (Element) list.item(i);
            String source=element.getAttribute("source");
            String target=element.getAttribute("target");
            if(map.containsKey(source)){
                map.get(source).addNext(map.get(target));
                map.get(target).addPre(map.get(source));
            }
        }
        //找出起点place
        Node start=null,end=null;
        for(Map.Entry<String, Node> entry : map.entrySet()){
            Node v = entry.getValue();
            if(v.getType()&&v.preSize()==0){
                start=v;
                break;
            }
        }
        for(Map.Entry<String, Node> entry : map.entrySet()){
            Node v = entry.getValue();
            if(v.getType()&&v.nextSize()==0){
                end=v;
                endId=v.getId();
                break;
            }
        }
        //结果list
        res=new LinkedHashSet<>();

        if(start.nextSize()!=0){
            List nodeP=new ArrayList();
            nodeP.add(start.getId());
            List<Node> nl=new ArrayList<>();
            nl.add(start);
            search(null,nl,new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        }


        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(logFile);
            int i=0;
            for(String s:res){
                System.out.println(s);
                fileWriter.write(s+"\r\n");
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void search(Node n,List<Node> ps,List<String> path,List<Node> NodeList,
                               List<String> noteId,List<String> toFinishId){
        if(null!=n) {//transition

            List<String> p=new ArrayList<>(path);
            List<String> nid=new ArrayList<>(noteId);
            nid.add(n.getId());
            p.add(n.getText());
            List<Node> next=new ArrayList<>();
            for(Node ne:n.getNext()){
                if(!nid.contains(ne.getId())||
                        nid.indexOf(ne.getId())==nid.lastIndexOf(ne.getId())) {
                    next.add(ne);
                }
            }
            search(null,next,p,NodeList,nid,toFinishId);
        }
        else if(ps.size()!=0){//place
            boolean fin=false;
            if(ps.get(0).getNext().size() == 3 && ps.get(0).getPre().size() == 4){
                System.out.println();
            }
            for(Node p:ps){
                if(p.getId().equals(endId)){
//                    for(String s:path){
//                        System.out.print(s+" ");
//                    }System.out.println();

                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < path.size(); i++) {
                        if (i == path.size() - 1) {
                            sb.append(path.get(i));
                        } else {
                            sb.append(path.get(i));
                            sb.append("->");
                        }
                    }
                    res.add(sb.toString());
//                    System.out.println(res.size());
                    fin=true;
                    break;
                }
                toFinishId.add(p.getId());
                noteId.add(p.getId());
            }
            if(!fin){
                List<List<Node>> nexts=getAllList(ps);
                for(List<Node> next:nexts){
//                    for(Node node :next){
//                        System.out.print(node.getText()+" ");
//                    }System.out.println();
                    List<Node> tmp=new ArrayList<>(NodeList);
                    tmp.addAll(next);
                    for(int i=0;i<tmp.size();){
                        Node node=tmp.get(i);
                        if(!noteId.contains(node.getId())||
                                noteId.indexOf(node.getId())==noteId.lastIndexOf(node.getId())){
                            boolean judge=true;
                            List<String> tf=new ArrayList<>(toFinishId);
                            for(Node nn:node.getPre()){
                                if(tf.contains(nn.getId())){
                                    tf.remove(tf.indexOf(nn.getId()));
                                }else{
                                    judge=false;
                                    break;
                                }
                            }
                            if(!judge&&"K".equals(node.getText())){
                                System.out.println();
                            }
                            if(judge){//可执行
                                List<Node> nl=new ArrayList<>(tmp);
                                nl.remove(i);
                                List<String> nid=new ArrayList<>(noteId);


                                search(node,null,path,nl,nid,tf);
                            }
                            i++;

                        }else{
                            tmp.remove(i);
                        }
                    }
                }

            }

        }

    }

    private static List<List<Node>> getAllList(List<Node> nodeList){
        List<List<Node>> res= new ArrayList<>();
        getList(nodeList,new ArrayList<>(),res,0);
        return res;
    }

    private static void getList(List<Node> nodeList,List<Node> toAdd,List<List<Node>> res,int index){
        if(nodeList!=null){
            if(index==nodeList.size()){
                res.add(toAdd);
            }else{
                List<Node> next=nodeList.get(index).getNext();
                for(int i=0;i<next.size();i++){
                    List<Node> ad=new ArrayList<>(toAdd);
                    ad.add(next.get(i));
                    getList(nodeList,ad,res,index+1);
                }
            }
        }

    }


    private static Document getDocument(String modelFile) {
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(modelFile));
            Element e = document.getDocumentElement();
            return document;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}

class Node {
    private String id;
    private String text;
    private List<Node> pre;
    private List<Node> next;
    private boolean type;//place true,transition false;

    public Node(String id,String text,boolean type){
        this.type=type;
        this.id=id;
        this.pre=new ArrayList<>();
        this.next=new ArrayList<>();
        this.text=text;
    }

    public boolean getType() {
        return type;
    }

    public int preSize(){
        return this.pre.size();
    }

    public int nextSize(){
        return this.next.size();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Node> getPre() {
        return pre;
    }

    public void addPre(Node pre) {
        this.pre.add(pre);
    }

    public List<Node> getNext() {
        return next;
    }

    public void addNext(Node next) {
        this.next.add(next);
    }
}

