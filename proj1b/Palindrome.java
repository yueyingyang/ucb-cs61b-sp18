public class Palindrome {

    public Deque<Character> wordToDeque(String word){

        int length = word.length();
        Deque<Character> wordDeque = new LinkedListDeque<Character>();
        for(int i = 0;i < length;i++){
            wordDeque.addLast(word.charAt(i));
        }

        return wordDeque;
    }

    public boolean isPalindrome(String word){

        Deque<Character> wordDeque = wordToDeque(word);
        return pop(wordDeque);
    }

    private boolean pop(Deque<Character> wordDeque){
        if(wordDeque.size() > 1){
            if(wordDeque.removeFirst() == wordDeque.removeLast()){
                return pop(wordDeque);
            }else{
                return false;
            }
        }
        return true;

    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> wordDeque = wordToDeque(word);
        return pop1(wordDeque, cc);

    }

    private boolean pop1(Deque<Character> wordDeque, CharacterComparator cc){

        if(wordDeque.size() > 1){
            if(cc.equalChars(wordDeque.removeFirst(), wordDeque.removeLast())){
                return pop1(wordDeque, cc);

            }else{
                return false;
            }
        }
        return true;



    }

}
