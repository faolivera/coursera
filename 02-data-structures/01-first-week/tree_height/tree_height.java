import java.util.*;
import java.io.*;

public class tree_height {

    static HashMap<Integer, TreeNode<Integer>> nodes;

    static public void main(String[] args) throws IOException {
        FastScanner in = new FastScanner();
        int n = in.nextInt();

        nodes = new HashMap<Integer, TreeNode<Integer>>();
        TreeNode<Integer> root = null;

        for (int value = 0; value < n; value++) {
            int parentIdx = in.nextInt();

            TreeNode<Integer> node = getNode(value);
            node.setData(value);

            if( parentIdx != -1) {
                TreeNode<Integer> parent = getNode(parentIdx);
                parent.addChild(node);
            } else {
                root = node;
            }
        }

       System.out.println(root.getHeight());
    }

    static private TreeNode<Integer> getNode(int idx) {
        TreeNode<Integer> node = nodes.get(idx); 
        if(node == null) {
            node = new TreeNode<Integer>();
            nodes.put(idx, node);
        }
        return node;
    }

    static class TreeNode<T> {
        private T data;
        private TreeNode<T> parent;
        private List<TreeNode<T>> childrens;

        public TreeNode() {
            this.childrens = new LinkedList<TreeNode<T>>();
        }

        public T getData() {
            return data;
        }

        public TreeNode<T> setData(T data) {
            this.data = data;
            return this;
        }

        public TreeNode<T> setParent(TreeNode<T> parent) {
            this.parent = parent;
            return this;
        }

        public TreeNode<T> addChild(TreeNode<T> child) {
            this.childrens.add(child);
            child.setParent(this);
            return this;
        }

        public int getHeight() {
            int height = 1;

            List<TreeNode<T>> currentChildrens = childrens;

            while(!currentChildrens.isEmpty()) {
                List<TreeNode<T>> grandChildrens = new LinkedList<TreeNode<T>>();
                for (TreeNode<T> children : currentChildrens) {
                    grandChildrens.addAll(children.getChildrens());
                }
                currentChildrens = grandChildrens;
                height++;
            }
            return height;
        }

        public List<TreeNode<T>> getChildrens() {
            return childrens;
        }      

        public void print() {

            StringBuffer childrensBuffer = new StringBuffer();
            for(TreeNode<T> children: childrens) {
                childrensBuffer.append(children.getData().toString() + " ");
            }

            String parentString = "-";
            if(parent != null)
                parentString = parent.getData().toString();

            System.out.println("node: " + data + ". parent: " + parentString +". childrens: " + childrensBuffer.toString());
        }

        public void printRecursive() {
            print();
            for(TreeNode<T> children: childrens) {
                children.printRecursive();
            }
        }
    }


    static class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

}
