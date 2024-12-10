package codSoft;
import java.util.*;
public class QuizApplication{
    static int roundCounter = 0;
    static int totalNamingTrials = 0;
    static Scanner console = new Scanner(System.in);//create scanner object
    static char[] correctAnswer = {'A','B','A','D','A','C','A','B','A','D','A','A','A','A','A','A','A','C','A','D'};
    static int totalCorrect = 0;
    static boolean[] quit =new boolean[20];
    static String name;
    //question store 
    static String[] questions = {"Who invented the telephone?\n","Who is known as the father of modern physics?\n", "Who discovered penicillin?\n",
            "Who invented the light bulb?\n" , "Who developed the theory of relativity?\n", "Who is credited with inventing the World Wide Web?\n",
    "Who discovered the law of gravity?\n", "Who invented the first practical telephone?\n", "Who is known for the development of the polio vaccine?\n"
    , "Who invented the first mechanical computer, known as the Analytical Engine?\n", "Who is considered the father of modern chemistry?\n" ,"Who invented the first successful airplane?\n",
            "Who discovered the circulation of blood in the human body?\n" ,"Who is known for the laws of planetary motion?\n",
            "Who discovered the structure of DNA?\n","Who is considered the father of electromagnetism?\n", "Who invented the first successful printing press? \n", "Who is known for the discovery of radioactivity? \n",
            "Who invented the steam engine? \n", " Who developed the quantum theory?\n"};
    //choice store
  static  String[] choices = {" A) Alexander Graham Bell\t B) Thomas Edison\t C) Nikola Tesla\t D) Guglielmo Marconi\n",
            " A) Albert Einstein\t B) Isaac Newton\t C) Galileo Galilei\t D) Niels Bohr \n",
            " A) Alexander Fleming\t B) Louis Pasteur\t C) Robert Koch\tD) Joseph Lister\n",
            " A) Nikola Tesla\t B) James Watt\t C) Michael Faraday\t D) Thomas Edison\n",
            " A) Albert Einstein\t B) Stephen Hawking\t C) Niels Bohr\t D) Max Planck\n",
            " A) Steve Jobs\t B) Bill Gates\t C) Tim Berners-Lee\t D) Larry Page\n",
            " A) Isaac Newton\tB) Albert Einstein\t C) Johannes Kepler\t D) Galileo Galilei\n",
            " A) Samuel Morse\t B) Alexander Graham Bell\t C) Thomas Edison\t D) Nikola Tesla\n",
            " A) Jonas Salk\t B) Louis Pasteur\t C) Alexander Fleming\t D) Robert Koch\n",
            " A) Blaise Pascal\t B) Alan Turing\t C) John von Neumann\t D) Charles Babbage\n",
            " A) Antoine Lavoisier\t B) Dmitri Mendeleev\t C) Robert Boyle\tD) Joseph Priestley\n",
            " A) Wright brothers\t B) Glenn Curtiss\t C) Alberto Santos-Dumont\t D) Leonardo da Vinci\n",
            " A) William Harvey\t B) Andreas Vesalius\t C) Edward Jenner\t D) Robert Hooke\n",
            " A) Johannes Kepler\t B) Galileo Galilei\t C) Nicolaus Copernicus\t D) Tycho Brahe\n",
            " A) James Watson and Francis Crick\t B) Gregor Mendel\t C) Rosalind Franklin\t D) Erwin Chargaff\n",
            " A) Michael Faraday\t B) André-Marie Ampère\t C) Hans Christian Ørsted\t D) James Clerk Maxwell\n",
            " A) Johannes Gutenberg\t B) William Caxton\t C) Aldus Manutius\t D) Laurens Janszoon Coster\n",
            " A) Ernest Rutherford\t B) Henri Becquerel\t C) Marie Curie\t D) Wilhelm Röntgen\n",
            " A) James Watt\t B) Thomas Newcomen\t C) George Stephenson\t D) Richard Trevithick\n",
            " A) Werner Heisenberg\t B) Albert Einstein\t C) Niels Bohr\t D) Max Planck \n"};
  
  
  //main method
    public static void main(String[] args) {
       nameOfUser();//invoke name checking method
        quize();//quiz method invoked
    }

    public static void nameOfUser() {
        while(totalNamingTrials<= 2){
            System.out.print("Enter your name: ");
            name = console.nextLine();
            char[] nameChars = name.toCharArray();
           boolean validName = true;
            //check name
            for(char c : nameChars){
                if(!Character.isLetter(c)){
                    System.out.print("Invalid name!");
                    totalNamingTrials++;
                    validName = false;
                }
            }
            if(validName){
                System.out.println("\n\tHello " + name + " \n\n_______Welcome to QUiz.com!_______\n");
                return;
            }

        }
        if(totalNamingTrials == 3) {
            System.out.println("Too many trials, Goodbye!");
            System.exit(0);
        }
    }

    
       //question should be random so randomize index store in the quizShuffler array 
     public static void quize() { 
        int[] quizShuffler = new int[questions.length];
        quizShuffler[0] = (int)(Math.random()*questions.length);
        for(int i = 1; i < questions.length; i++){
            int index = (int)(Math.random()*questions.length);
                quizShuffler[i] = index ;
        }
        takeTest(quizShuffler);//calling a method
    }

 
    public static void takeTest(int[] quizShuffler) {
    	int k = 0;
        char[] userAnswer = new char[questions.length];
        System.out.println("Attention! You have 30 secondS for each question.");
        while(roundCounter<20){
            roundCounter++;
            System.out.println("\n________________ #Question " + roundCounter + " _________________\n");
            long startingTime = System.currentTimeMillis()/1000;
            System.out.println(questions[quizShuffler[k]]);
            System.out.println(choices[quizShuffler[k]]);
            System.out.print("Select: ");
            char selection = console.nextLine().trim().toUpperCase().charAt(0);//one upper cased character stored from the user input
            if(isValidChoice(selection)) 
            userAnswer[k] = selection;
            else if(!isValidChoice(selection)) {
            	System.out.println("Invalid choice, try Again.");//for invalid selection or choice
            	k = k -1;
            	roundCounter--;
                takeTest(quizShuffler);// recursion of the take_Test method
            }
            else {}	
            long currentTime = System.currentTimeMillis()/1000;
            if(currentTime-startingTime < 31) {//time checker
                if(userAnswer[k] == correctAnswer[quizShuffler[k]]) 
                	totalCorrect++;
                System.out.printf("You get %d out of %d\n\n", totalCorrect, roundCounter );	
                k++;
            }else {
            	System.out.println("Sorry Time is up!");
            	quit[k] = true;
            	
            }
        }
        
        //display the quiz summary
        if(roundCounter == 20 ) {
        	System.out.println("Hello " + name+", Your quiz review is here:\n");
        	for(int i  = 0; i < roundCounter; i++) {
        		System.out.printf("\t%d. The correct Answer is: %s\n",(i+1), correctAnswer[quizShuffler[i]]);
        		if(quit[i]) {
        			System.out.println("Time was up for this question!");
        			continue;
        		}
        		if(userAnswer[i] == correctAnswer[quizShuffler[i]]) {
        			System.out.println("\t\tYou were correct!");
        		}
        		else {
        			System.out.printf("\t\tYou weren't correct! Your Answer was: %s\n", userAnswer[i]);
        		}
        	}

        }
        System.out.println("______________________________________________");
    	double percentageScore = (totalCorrect/(double)roundCounter)*100;
    	System.out.printf("Your Answer was %.2f ", percentageScore);System.out.println("successful.");
    	 System.out.println("______________________________________________");
    	 System.out.println("______________________________________________");
    	return;
    }
    public static boolean isValidChoice(char choice) {
    	if(choice>= 'A' && choice <= 'D')
    		return true;
    	return false;
    }
   
}
