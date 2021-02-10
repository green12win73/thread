package com.fq.thread.design;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fangqi
 * @description
 * @date 2020/5/25 8:48
 */
public class Composite_02 {
    //抽象节点
    static abstract class AbstractNode{
        //节点名称
        private String nodeName;

        private List<AbstractNode> nodes = new ArrayList<>();

        public AbstractNode(String name){
            this.nodeName = name;
        }

        //添加子级节点
        public void addNode(AbstractNode node){
            this.nodes.add(node);
        }

        //查看子级节点
        public List<AbstractNode> getNodes(){
            return this.nodes;
        }

        //查看节点名称
        public String getNodeName(){
            return this.nodeName;
        }
    }
    //根节点
    static class RootNode extends AbstractNode{
        public RootNode(String name){
            super(name);
        }
    }

    //分支节点
    static class BranchNode extends AbstractNode{
        public BranchNode(String name){
            super(name);
        }
    }

    //叶子节点
    static class LeafNode extends AbstractNode{
        public LeafNode(String name){
            super(name);
        }
    }

    public static void main(String[] args) {
        RootNode rootNode = new RootNode("研发部门");
        BranchNode developNode = new BranchNode("研发组");
        BranchNode testNode = new BranchNode("测试组");
        LeafNode structureNode = new LeafNode("架构小组");
        LeafNode dbaNode = new LeafNode("DBA小组");
        LeafNode demandNode = new LeafNode("需求小组");
        LeafNode functionNode = new LeafNode("功能测试小组");
        LeafNode performanceNode = new LeafNode("性能小组");

        developNode.addNode(structureNode);
        developNode.addNode(dbaNode);
        developNode.addNode(demandNode);

        testNode.addNode(functionNode);
        testNode.addNode(performanceNode);

        rootNode.addNode(developNode);
        rootNode.addNode(testNode);
        //打印组织结构
        System.out.println(rootNode.getNodeName());
        for (AbstractNode node : rootNode.getNodes()) {
            System.out.println("    |--"+node.getNodeName());
            for (AbstractNode leafNode : node.getNodes()) {
                System.out.println("        |--"+leafNode.getNodeName());
            }
        }
    }

}
