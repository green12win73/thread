package com.fq.thread.design;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fangqi
 * @description
 * @date 2020/5/25 8:48
 */
public class Composite_04 {
    //抽象节点
    static abstract class AbstractNode{
        //节点名称
        private String nodeName;

        public AbstractNode(String name){
            this.nodeName = name;
        }

        //添加子级节点
        public void addNode(AbstractNode node){

        }
        //查看子级节点
        public List<AbstractNode> getNodes(){
            return null;
        }

        //查看节点名称
        public String getNodeName(){
            return this.nodeName;
        }
    }
    //节点
    static class Node extends AbstractNode{

        public List<AbstractNode> nodes = new ArrayList<>();

        public Node(String name){
            super(name);
        }

        @Override
        public void addNode(AbstractNode node) {
            this.nodes.add(node);
        }

        @Override
        public List<AbstractNode> getNodes() {
            return this.nodes;
        }
    }
    //叶子节点
    static class LeafNode extends AbstractNode{
        public LeafNode(String name){
            super(name);
        }
    }

    public static void printNode(AbstractNode abstractNode, int level){
        if(null!=abstractNode) {
            //打印节点名称
            System.out.println(tab(level) + abstractNode.getNodeName());
            //遍历子级节点
            if (null != abstractNode.getNodes() && 0 < abstractNode.getNodes().size()){
                ++level;
                for (AbstractNode node : abstractNode.getNodes()) {
                    printNode(node, level);
                }
            }
        }
    }

    private static String tab(int num){
        StringBuilder stringBuilder = new StringBuilder();
        if(num>0){
            for (int i = 0; i < num; i++) {
                stringBuilder.append("  ");

            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        AbstractNode rootNode = new Node("研发部门");
        AbstractNode developNode = new Node("研发组");
        AbstractNode testNode = new Node("测试组");
        AbstractNode structureNode = new LeafNode("架构小组");
        AbstractNode dbaNode = new LeafNode("DBA小组");
        AbstractNode demandNode = new LeafNode("需求小组");
        AbstractNode functionNode = new LeafNode("功能测试小组");
        AbstractNode performanceNode = new LeafNode("性能小组");

        developNode.addNode(structureNode);
        developNode.addNode(dbaNode);
        developNode.addNode(demandNode);

        testNode.addNode(functionNode);
        testNode.addNode(performanceNode);

        rootNode.addNode(developNode);
        rootNode.addNode(testNode);
        //打印组织结构
        printNode(rootNode, 0);
    }
}
