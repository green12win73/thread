package com.fq.thread.design;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fangqi
 * @description
 * @date 2020/5/25 8:48
 */
public class Composite_01 {

    //根节点
    static class RootNode{
        //节点名称
        private String rootName;

        private List<BranchNode> branchNodes = new ArrayList<>();

        public RootNode(String name){
            this.rootName = name;
        }

        //添加分支节点
        public void addNode(BranchNode node){
            this.branchNodes.add(node);
        }

        //查看分支节点
        public List<BranchNode> getBranchNodes(){
            return this.branchNodes;
        }

        public String getRootName(){
            return this.rootName;
        }
    }

    //分支节点
    static class BranchNode{
        //分支名称
        private String branchName;

        private List<LeafNode> leafNodes = new ArrayList<>();

        public BranchNode(String name){
            this.branchName = name;
        }

        //添加叶子节点
        public void addNode(LeafNode node){
            this.leafNodes.add(node);
        }

        //查看叶子节点
        public List<LeafNode> getLeafNodes(){
            return this.leafNodes;
        }

        public String getBranchName(){
            return this.branchName;
        }
    }

    //叶子节点
    static class LeafNode{
        //叶子节点名称
        private String leafName;

        public LeafNode(String name){
            this.leafName = name;
        }

        public String getLeafName(){
            return this.leafName;
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
        System.out.println(rootNode.getRootName());
        for (BranchNode branchNode : rootNode.getBranchNodes()) {
            System.out.println("    |--"+branchNode.getBranchName());
            for (LeafNode leafNode : branchNode.getLeafNodes()) {
                System.out.println("        |--"+leafNode.getLeafName());
            }
        }
    }

}
