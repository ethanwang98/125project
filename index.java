import java.util.*;
import java.lang.Math.*;
import java.io.*;

class Posting{
    String docid;
    int wf;
    Vector<Integer> indices;
    float tfidf;
    int doclen;
}

public class index{
    /*Strips all non-alphanumeric characters. The \w unicode includes alphanumeric characters as well as underscores, so we use _ to
    exclude them and replace them with a space. We then separate the tokens using whitespaces as a delimiter.*/
    public List<String> tokenize(String txt){
        String pattern = "^[_a-zA-Z0-9]*$";
        txt = txt.replaceAll(pattern, " ");
        String[] tokens = txt.split(" ");
        List<String> result = Arrays.asList(tokens);
        return result;
    }

    /*Calculates term frequency for all tokens by iterating incrementing each occurence of the term in the dictionary, then
    dividing the total count by the number of tokens.*/
    public Map<String, Float> calcTF (List<String> tokens){
        Map<String, Integer> counter = new HashMap<String, Integer>();
        Map<String, Float> result = new HashMap<String, Float>();
        for (int i = 0; i < tokens.size(); i++){
            counter.put(tokens.get(i), counter.get(tokens.get(i)) + 1);
        }
        int tokenlen = tokens.size();
        for (String key : counter.keySet()){
            Float tf = (float) counter.get(key)/tokenlen;
            result.put(key, tf);
        }
        return result;
    }

    public Map<String, Float> calcIDF (){
        Map<String, Integer> counter = new HashMap<String, Integer>();
        Map<String, Float> result = new HashMap<String, Float>();
        String curDir = new File(".");
        int folder_count, doc_count, N = 0;
        File[] filesList = curDir.listFiles();
    }

    public static void main(String[] args){
        defaultdict<String, List<Posting>> inv_index = new defaultdict<String, List<Posting>>(ArrayList.class);
        System.out.println("Hello world");
    }
}