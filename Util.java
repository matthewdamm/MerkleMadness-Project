public class Util {
    public String getMerkleRoot(ArrayList<String>1stItems){

        // Hard coding transaction count to 4.
        MerkleNode oNode1=new MerkleNode();
        MerkleNode oNode2=new MerkleNode();
        MerkleNode oNode3=new MerkleNode();
        MerkleNode oNode4=new MerkleNode();
        MerkleNode oNode5=new MerkleNode();
        MerkleNode oNode6=new MerkleNode();
        MerkleNode oNode7=new MerkleNode();
        //star building Tree
        oNode1.sHash= generateHash(1stitem.get(0));
        oNode2.sHash= generateHash(1stitem.get(1));
        oNode3.sHash= generateHash(1stitem.get(2));
        oNode4.sHash= generateHash(1stitem.get(3));
        populateMerkleNode(oNode5, oNode1, oNode2);
        populateMerkleNode(oNode6, oNode3,oNode4);

        // get fina merk;e root node.
        populateMerkleNode(oNode7, oNode5, oNode6);
        return oNode7.sHash
    }

    private void populateMerkleNode(MerkleNode,oNode, MerkleNode, oLeftNode, MerkleNode,oRightNode){

        oNode.oLeft=oLeftNode;
        oNode.oRight=oRightNode;
        oNode.sHash= generateHash(oNode.oLeft.sHash + oNode.oRight.sHash);
    }
    public synchronized String generateHash(String sOriginal){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] btEncodedhash = digest.digest(
                    sOriginal.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < btEncodedhash.length; i++) {
                sb.append(Integer.toString((btEncodedhash[i] & 0xff) + 0x100,
                        16).substring(1));
            }
            return sb.toString();
        }
        catch(Exception ex){
            System.out.println("Error generating hash: " + ex.getMessage());
            return null;
        }
    }
}
