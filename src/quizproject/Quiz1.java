package quizproject;

import java.util.Scanner;

public class Quiz1 {
	private static Participant participant;
	private static Question[] questions;
	private static final int MAXLIFELINE=3;
	private static int totalReward = 0;
    private static int lifelinesUsed = 0;
    
    private static boolean skipUsed = false;
    private static boolean eliminateUsed = false;
    private static boolean predictionUsed = false;
	
        public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			
			/*ENTERING THE DETAILS OF PARTICIPANT*/
			
			
			System.out.println("    ----WELCOME TO THE QUIZ----");
			System.out.println();
			
			System.out.println("----ENTER THE PARTICIPANT NAME----");
			String name=sc.nextLine();
			
			System.out.println("----ENTER THE PARTICIPANT AGE----");
			int age=sc.nextInt();
			sc.nextLine();
			System.out.println("----ENTER THE PARTICIPANT EMAIL----");
			String email=sc.nextLine();
			
			
			participant=new Participant(name,age,email);
			
			//questions
			
			questions =new Question[] {
					
					new Question("1. What is the Capital of India ?", new String[] {"A. Delhi","B. kolkata","C. bangalore","D. Mumbai"} ,'A', 10 ),
					new Question("2. Who is the Father of Nation ?", new String[] {"A. DR.B R Ambedkar","B. Mahathma Gandhi","C. Subhash chandra bose","D. Kempegowda"} ,'B', 10 ),
					new Question("3. Which planet in the solar system is known as the “Red Planet” ?", new String[] {"A. Venus","B. Earth","C. Mars","D. jupiter"} ,'C', 10 ),
					new Question("4. What is the capital of Japan ?", new String[] {"A. Beijing","B. Tokyo","C. Seoul","D. Bangkok"} ,'B', 10 ),
					new Question("5. Which river is the longest in the world ?", new String[] {"A. Amazon","B. Mississippi","C. Nile","D. Yangtze"} ,'D', 10 ),
					new Question("6. What is the official currency of Japan ?", new String[] {"A. Won","B. 	Yuan","C. Yen","D. Dollars"} ,'c', 10 ),
					new Question("7. Which is the richest country in the world ?", new String[] {"A. Qatar","B. Russia","C. The USA","D. The UAE"} ,'A', 10 ),
					new Question("8. Which county is the biggest grower of coffee? ?", new String[] {"A. Spain","B. India","C. Ethiopia","D. Brazil"} ,'D', 10 ),
					new Question("9. What element is the main constituent of diamonds ?", new String[] {"A. Carbon","B. Oxygen","C. Silver","D. Gold"} ,'A', 10 ),
					new Question("10. Which river is the second longest in the world? ?", new String[] {"A. Amazon","B. Yangtze","C. Nile","D. Mississippi"} ,'B', 10 ),

			};

			//START THE QUIZ
			
			
			
			for(Question q : questions) {
				
			
				
				System.out.println(q.question);
				
				for(String option : q.options) {
					System.out.println(option);
				}
				
				
				System.out.println("Enter your Answer (A/B/C/D)  OR 'L' FOR THE *!LIFELINE!* : ");   
				char answer=sc.nextLine().toUpperCase().charAt(0);
				
				
				
				// condition if lifeline  is clicked
				
				
				if(answer=='L') {
					if(lifelinesUsed <MAXLIFELINE) {
						lifelinesUsed++;
						useLifeLine( q, sc);
						
						
					}
					
					else {
						System.out.println("No Lifeline left .Answer the question");
						System.out.println("Enter your Answer .. (A/B/C/D)");
						answer=sc.nextLine().toUpperCase().charAt(0);
						if(answer==q.correctAnswer) {
							
							System.out.println("");
						}
						
						else {
							System.out.println("Wrong answer. You earned a total of " + totalReward + " points.");
		                    
		                    return;
						}
						
					}
				}
				
				
				
				if (answer==q.correctAnswer) {
					totalReward +=q.reward;
					
					System.out.println("Correct! You have earned " + q.reward + " points. Total reward: " + totalReward);
	            } else if(answer!=q.correctAnswer && answer!='L') {
	                System.out.println("Wrong answer. \n "+name+ " You earned a total of " + totalReward + " points.");
	                return;
	            }}
	        
      
	        System.out.println("Quiz over \n Dear "+name+" . You earned a total of " + totalReward + " points.");
	    }
        
				
				//METHOD FOR LIFELINE
				
				private static void useLifeLine(Question q,Scanner scanner)
				{
					
					
					System.out.println("Choose the Lifeline");
					
					System.out.println("1. skip the quiz ");
					System.out.println("2. Eliminate 2 incorrect option ");
					System.out.println("3. Get an prediction option");
					
					int choice=scanner.nextInt();
					scanner.nextLine();   //for newline
					
					
					switch(choice) {
					
					case 1:
						if (skipUsed) {
			                System.out.println("This lifeline has already been used.\n");
			                // Display the current question without skipping
			                System.out.println(q.question);
			                for (String option : q.options) {
			                    System.out.println(option);
			                }
			                System.out.println("Enter your Answer (A/B/C/D) OR 'L' FOR THE *!LIFELINE!* :");
			                char answer=scanner.nextLine().toUpperCase().charAt(0);
							if(answer==q.correctAnswer) {
								totalReward+=q.reward;
								System.out.println("CORRECT!!, you have earned "+q.reward+"points. your total points is: "+totalReward );
							}
							else if(answer=='L') {
								useLifeLine( q, scanner);
							}
							else {
								System.out.println("Wrong answer. You earned a total of " + totalReward + " points.");
			                    System.exit(0);
							}
			            } 
						else {
						System.out.println("question skipped");
						q.reward=totalReward;
						skipUsed=true;
						
						return ;
						}
						break;
						
						
					case 2:
						if (eliminateUsed) {
		                    System.out.println("This lifeline has already been used.");
		                    System.out.println(q.question);
			                for (String option : q.options) {
			                    System.out.println(option);
			                }
			                
			                System.out.println("Enter your Answer (A/B/C/D) OR 'L' FOR THE *!LIFELINE!* :");
			                char answer=scanner.nextLine().toUpperCase().charAt(0);
							if(answer==q.correctAnswer) {
								totalReward+=q.reward;
								System.out.println("CORRECT!!, you have earned "+q.reward+"points. your total points is: "+totalReward );
							}
							else if(answer=='L') {
								useLifeLine( q, scanner);
							}
							else {
								System.out.println("Wrong answer. You earned a total of " + totalReward + " points.");
			                    System.exit(0);
							}
		                }
						else {
						eliminateOptions(q);
						System.out.println("Enter your answer (A/B/C/D):");
						char answer=scanner.nextLine().toUpperCase().charAt(0);
						if(answer==q.correctAnswer) {
							totalReward+=q.reward;
							System.out.println("CORRECT!!, you have earned "+q.reward+"points. your total points is: "+totalReward );
						}
						else {
							System.out.println("Wrong answer. You earned a total of " + totalReward + " points.");
		                    System.exit(0);
						}
						eliminateUsed = true;
						return ;

						}
						break;
						
					case 3:
						if (predictionUsed) {
		                    System.out.println("This lifeline has already been used.");
		                } 
						else {
							
						System.out.println("predicted option is : "+q.correctAnswer);
						System.out.println("Enter your answer (A/B/C/D):");
						char hintanswer=scanner.nextLine().toUpperCase().charAt(0);
						if(hintanswer==q.correctAnswer) {
							totalReward+=q.reward;
							System.out.println("CORRECT!!, you have earned "+q.reward+"points. your total points is: "+totalReward );
						}
						else {
							System.out.println("Wrong answer. You earned a total of " + totalReward + " points.");
		                    System.exit(0);
						}
						predictionUsed=true;
						return ;
						}
						break;	
						
					default:
						
						System.out.println("Invalid Choice!!");
						break;
					}
				}
				
				
				//METHOD FOR ELIMINATING THE OPTIONS IN LIFLINE
				
				public static void eliminateOptions(Question q) {
					System.out.println("2 incorrrect options eliminated!!!");
					int eliminated =0;
					for(String option:q.options) {
						if(option.charAt(0)!=q.correctAnswer && eliminated < 2) {
							System.out.println("----");
							eliminated++;
						}
						else {
							System.out.println(option);
						}
					}
				}
			
			
		}


    //FOR STORING PARTICIPANT DETAIL

	class Participant{
		String name;
		int age;
		String email;
		
		public Participant(String name,int age,String email) {
			this.name=name;
			this.age=age;
			this.email=email;
		}
	}
	
	
	class Question{
		String question;
		String[] options;
		char correctAnswer;
		int reward;
		
		public Question(String question,String[] options,char correctAnswer,int reward) {
			this.question=question;
			this.options=options;
			this.correctAnswer=correctAnswer;
			this.reward=reward; 
		}
	}
	
