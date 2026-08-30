package Arrays;

public class M {
    M left;
    M right;
    int val;
    M(int val){
        this.val = val;
    }


    public static int nodecount(M root){
        if(root==null){
            return 0;
        }
        return 1+ nodecount(root.left) + nodecount(root.right);


    }

    public static void main(String[] args) {

        M root = new M(1);

        root.left = new M(2);
        root.right = new M(3);

        root.left.left = new M(4);
        root.left.right = new M(5);

        int ans = nodecount(root);

        System.out.println(ans);
    }
}
