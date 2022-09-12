import java.util.ArrayList;

public class MerkleThread implements Runnable
{
    String sThreadName1 = "Merkle";
    public static volatile ArrayList<String>lstWords;
    private int iMerkleTreeInputs = 4;

    public void run()
    {

        Util oUtil = new Util();
        lstWords = new ArrayList();

        while (true)
        {
            oUtil.sleepRandomTime(sThreadName1);
            String sNewWord = MerkleManager.grabWord();

            if (sNewWord != null)
            {
                System.out.println("[merkle] Word Grabbed");
                lstWords.add(sNewWord);

                if(lstWords.size() == iMerkleTreeInputs)
                {
                    MerkleManager.sMerkleRoot = oUtil.getMerkleRoot(lstWords);
                }
            }
        }
    }
}
