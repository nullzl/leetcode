package com.nullzl.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Interview1707 {

    class Node{
        public int index;
        public int count;
        public Node(int i,int c){
            index = i;
            count = c;
        }
    }


    private Node find(ArrayList<Node> nodes,int index){
        if(index == nodes.get(index).index)
            return nodes.get(index);
        Node root = find(nodes,nodes.get(index).index);
        nodes.set(index,root);
        return root;
    }

    private void union(ArrayList<String> names,ArrayList<Node> nodes,int op1,int op2){
        Node root1 = find(nodes,op1);
        Node root2 = find(nodes,op2);
        if(root1 == root2)
            return ;
        String name1 = names.get(root1.index);
        String name2 = names.get(root2.index);
        if(name1.compareTo(name2) < 0){
            root1.count += root2.count;
            nodes.set(root2.index,root1);
        }else{
            root2.count += root1.count;
            nodes.set(root1.index,root2);
        }
    }

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        if(null == names || 0 == names.length)
            return new String[0];

        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<Node> nodes = new ArrayList<>(names.length << 1);
        ArrayList<String> ns = new ArrayList<>(names.length << 1);
        for(int i = 0 ; i < names.length; i++){
            String name = names[i].substring(0,names[i].indexOf('('));
            int num = Integer.parseInt(names[i].substring(names[i].indexOf('(') + 1,names[i].indexOf(')')));
            ns.add(name);
            map.put(name,i);
            nodes.add(new Node(i,num));
        }

        for(String edge : synonyms){
            int mid = edge.indexOf(",");
            String from = edge.substring(1,mid);
            String to = edge.substring(mid + 1,edge.length() - 1);
            int index1 = map.getOrDefault(from,-1);
            int index2 = map.getOrDefault(to,-1);
            if(-1 == index1){
                int size = ns.size();
                map.put(from,size);
                nodes.add(new Node(size,0));
                ns.add(from);
                index1 = size;
            }
            if(-1 == index2){
                int size = ns.size();
                map.put(to,size);
                nodes.add(new Node(size,0));
                ns.add(to);
                index2 = size;
            }
            union(ns,nodes,index1,index2);
        }
        String[] rs = new String[names.length];
        int j = 0;
        for(int i = 0 ; i < nodes.size() ; i++){
            if(i != nodes.get(i).index || 0 == nodes.get(i).count)
                continue;
            StringBuilder builder = new StringBuilder(ns.get(i))
                    .append('(').append(nodes.get(i).count).append(')');
            rs[j++] = builder.toString();
        }
        return Arrays.copyOf(rs,j);

    }

    public static  void main(String[] args){

        String[] s1 = new String[]{"Prf(48)","Zvzm(31)","Bbcpth(256)","Jmqqsj(19)","Uwy(26)","Jylbla(100)","Xioal(11)","Npbu(62)","Jpftyg(96)","Alqw(424)","Kxjw(36)","Clplqf(8)","Fayxe(155)","Slfwyo(82)","Xbesji(70)","Oip(13)","Fzoe(130)","Sqwejn(19)","Gsiiyo(215)","Bcs(262)","Icsvku(1)","Vaakt(21)","Axaqkm(100)","Gaoo(98)","Ghlj(35)","Umt(13)","Rqa(117)","Zhc(44)","Slh(66)","Orpqim(69)","Gql(67)","Sfjdjc(62)","Ccqunq(186)","Oyo(32)","Bvnkk(52)","Pxzfjg(91)","Kaaht(28)","Vqnjg(142)","Fshi(62)","Phlto(41)","Lnow(157)","Mqgga(31)","Adlue(171)","Dma(170)","Jnij(75)","Ghk(14)","Mrqlne(39)","Rmlbnj(98)","Aasipa(262)","Wzt(41)","Xuzubb(90)","Kmrev(31)","Iggrg(99)","Lwyfn(50)","Qlvglt(36)","Jxv(152)","Ttj(28)","Ndc(62)","Bjfkzo(54)"};
        String[] s2 = new String[]{"Rqa(117)","Jnij(75)","Dma(170)","Fshi(62)","Alqw(424)","Sfjdjc(62)","Xbesji(70)","Zvzm(31)","Bbcpth(256)","Aasipa(262)","Icsvku(1)","Mqgga(31)","Vqnjg(142)","Rmlbnj(98)","Prf(48)","Adlue(171)","Bjfkzo(54)","Orpqim(69)","Ghk(14)","Oip(13)","Sqwejn(19)","Slfwyo(82)","Kxjw(36)","Ndc(62)","Bcs(262)","Jpftyg(96)","Npbu(62)","Jylbla(100)","Gsiiyo(215)","Xioal(11)","Kmrev(31)","Ccqunq(186)","Pxzfjg(91)","Vaakt(21)","Qlvglt(36)","Jxv(152)","Fayxe(155)","Umt(13)","Uwy(26)","Slh(66)","Jmqqsj(19)","Gql(67)","Bvnkk(52)","Kaaht(28)","Mrqlne(39)","Ttj(28)","Clplqf(8)","Phlto(41)","Fzoe(130)","Zhc(44)","Gaoo(98)","Wzt(41)","Iggrg(99)","Ghlj(35)","Lwyfn(50)","Lnow(157)","Oyo(32)","Axaqkm(100)","Xuzubb(90)"};
        HashSet<String> set = new HashSet<>();
        for(String s : s1){
            if(set.contains(s)){
                System.out.println(s + "\t" + 1);
                return;
            }

            set.add(s);
        }

        for(String s : s2){
            if(!set.contains(s)){
                System.out.println(s + "\t" + 2);
            }
        }

    }

}
