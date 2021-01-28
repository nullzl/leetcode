package main.java.com.nullzl.leetcode300;

public class LeetCode208 {

    class Trie {

        class TireTreeNode{
            private TireTreeNode[] children;
            private boolean word;

            public TireTreeNode(){
                this.children = new TireTreeNode['z' - 'a' + 1];
                word = false;
            }

            public TireTreeNode next(char ch){
                return this.children[ch - 'a'];
            }

            public void setWrod(){
                this.word = true;
            }
            public void addChild(char ch,TireTreeNode node){
                this.children[ch - 'a'] = node;
            }
            public boolean isWord(){
                return this.word;
            }
        }

        private TireTreeNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TireTreeNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {

            TireTreeNode node = root;
            TireTreeNode preNode = null;
            int i = 0;
            for(; i < word.length() && null != node ; i++){
                char ch = word.charAt(i);
                preNode = node;
                node = node.next(ch);
            }
            if(null == node){
                for(i = i - 1; i < word.length() ; i++){
                    node = new TireTreeNode();
                    char ch = word.charAt(i);
                    preNode.addChild(ch,node);
                    preNode = node;
                }
                preNode.setWrod();
            }else{
                node.setWrod();
            }


        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TireTreeNode node = root;
            int i = 0;
            for(; i < word.length() && null != node ; i++){
                char ch = word.charAt(i);
                node = node.next(ch);
            }
            if(null == node || !node.isWord())
                return false;
            return true;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TireTreeNode node = root;
            int i = 0;
            for(; i < prefix.length() && null != node ; i++){
                char ch = prefix.charAt(i);
                node = node.next(ch);
            }
            if(null == node)
                return false;
            return true;
        }
    }

    public static void main(String[] args){
        LeetCode208 l = new LeetCode208();
        Trie trie = l.new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("apple")); // 返回 true
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 true
    }
}
