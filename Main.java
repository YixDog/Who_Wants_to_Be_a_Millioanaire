
import java.io.*;
import java.util.*;
import enigma.core.Enigma;


public class Main {
	public static enigma.console.Console enigma = Enigma.getConsole("Mouse and Keyboard");
    static int CursorX =0;
    static boolean timesup=true;
	
	static void Menu() {

		System.out.println("* Menu *\r\n"
				+ "1.Load questions\r\n"
				+ "2.Load participants\r\n"
				+ "3.Start competition \r\n"
				+ "4.Show statistics\r\n"
				+ "5.Exit");
	}
	
	static String[] wrong(String[]array,String dic[],String[]array2) {
		boolean flag=true;
		int counter=0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < dic.length; j++) {
				if(!(array[i].equals(null)) &&array[i].equalsIgnoreCase(dic[j])) {
					flag=false;
					break;
				}
				else
					flag=true;
				
			}
			if(flag) {
				array2[counter]=array[i];
				counter++;
				
			}
		}
		return array2;
	}
	static int wrongcounter(String[]array,String dic[]) {
		boolean flag=true;
		int counter=0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < dic.length; j++) {
				if(!(array[i].equals(null)) &&array[i].equalsIgnoreCase(dic[j])) {
					flag=false;
					break;
				}
				else
					flag=true;
				
			}
			if(flag) {
				
				counter++;
				
			}
		}
		return counter;
	}
	static String[] Reading(String[]array,String txt) {
	int counter=0;
	try 
	{        
	File file = new File(txt);
	Scanner x=new Scanner(file);
	while(x.hasNextLine())
	{
	String line=x.nextLine();
	array[counter]=line;
	//System.out.println(counter);
	//System.out.println(array[counter]);
	
	counter++;
	}
	x.close();
	} catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		return array;
	}
						
    static int Counter(String number,int counter,String[]array) {
    	for(int i=0;i<array.length;i++) {
			if(array[i].endsWith(number)) {
				counter++;
			}
    }
    	return counter;
    }
    static void Printing(int counter1,int counter2,int counter3,int counter4,int counter5) {
    	
    	System.out.println("Difficulty level    The number of questions ");
    	 
    		System.out.println(" 1"+"                   "+counter1);
    		System.out.println(" 2"+"                   "+counter2);
    		System.out.println(" 3"+"                   "+counter3);
    		System.out.println(" 4"+"                   "+counter4);
    		System.out.println(" 5"+"                   "+counter5);
	
	}
    static int [] Random(int []randomnums,String []dic) {
    	
    	for (int i = 0;i<13;i++) {
    		boolean Contains = true;
    		Random random=new Random();
			int randomnum=random.nextInt(dic.length);
		
			while(Contains==true)
			{ 
			  Contains = false;
		      randomnum=random.nextInt(dic.length);
			  for (int j = 0;j<13;j++) 
			  {
				  
				if(randomnums[j]==randomnum)
				{
					Contains = true;
					break;
				}
				
			  }
			  
			}
				
			randomnums[i]=randomnum;
    	}
    	return randomnums;
 }
    static String wordc(String[]array) {  	
    	String tempr="";
		for (int i = 0; i < array.length; i++) {
			
			tempr=tempr+" "+array[i];

		}
	tempr=tempr.trim();

	return tempr;
    	
    }
    static int blank(String tempr) {
		int counter11=0;
		for(int j=0;j<tempr.length();j++) {
				if(j<tempr.length()&&tempr.substring(j,j+1).equals(" ")){
					counter11++;
				}
		}
		
		return counter11;
	}
	
	static void Cloud(int[]randomnums,String []dic2) {
		String blank="     ";
		for (int i = 1; i < 13; i++) {		
			System.out.print(dic2[randomnums[i]]+blank);	
			if(i%4==0)
			System.out.println();
			
		}
		
		
	}
	static String[] stopw(String[]array,String[]array2,String[]array3) {
		int counter=0;
		boolean flag=true;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				if(array[i].length()==array2[j].length()) {
				if(array[i].equalsIgnoreCase(array2[j])) {
					
					flag=false;
					break;
				}
				else {
					flag=true;
				}
				
			}
			}
			if(flag==true&&!(array[i].equals(""))&&array[i]!=null) {
				array3[counter]=array[i];
				counter++;
				
			}
			
		}
		return array3;
	}
	static String[] wcloud(String[]questions,String[]dic,String[]array3) {
        int index=0;
        int counter2=0;
        boolean flag=false;
        char temp='a';
        for (int i = 0; i < array3.length; i++) {
            
                 
                 for (int j1 = 0; j1 < dic.length; j1++) {
                     
                     if(array3[i].length()>1&&array3[i].length()==dic[j1].length()) {
                         
                    for (int j2 = 0; j2 < array3[i].length(); j2++) {
                        
                        if(array3[i].charAt(j2)==dic[j1].charAt(j2)) {
                            counter2++;
                        }
                        else {
                            index=j2;
                            temp=dic[j1].charAt(j2);
                        }
                        
                        
                    }
                     }
                 
                    if(array3[i].length()>1&&counter2==array3[i].length()-1) {
                        String temp3="";        
                        char[]carray=new char[array3[i].length()];
                        carray=array3[i].toCharArray();
                                carray[index]=temp;
                                
                        
                        for (int j = 0; j < carray.length; j++) {
                            temp3=temp3+carray[j];
                            
                        }

                        if(temp3.equalsIgnoreCase(dic[j1])) {
                            for (int j = 0; j < questions.length; j++) {
                                if(questions[j].contains(array3[i])) {
                                    questions[j]=questions[j].replace(array3[i],dic[j1]);
                                    break;
                                }
                                
                            }
                         }
                        else
                            temp3="";
                    }
                    counter2=0;
                    
                 }
                 
            }
        return questions;
    }
	static int arraySize(String txt){
		int counter=0;
		try 
		{        
		File file = new File(txt);
		Scanner x=new Scanner(file);
		while(x.hasNextLine())
		{
		String line=x.nextLine();
		counter++;
		}
		x.close();
		} catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return counter;
	}
	static String[] cat(String[]array,String[]array2,String cat) {

		int counter=0;
		for(int a1=0;a1<array.length;a1++) {
			if(array[a1].endsWith(cat)) {
			int index1=array[a1].indexOf("#");
			int index2=array[a1].indexOf("#", index1+1);
			array2[counter]=array[a1].substring(index1+1, index2).replaceAll("\\p{Punct}","").trim();
			counter++;
			}
		}
			return array2;
	}
	static String[] reversed(String[]array3,String[]dic,String[]questions) {

		boolean flag=true;
		int index=0;
		int index1=0;
		int counter=0;
		for (int i = 0; i < array3.length; i++) {
			for (int j1 = 0; j1 < dic.length; j1++) {
				 if(array3[i]!=null&&array3[i].length()==dic[j1].length()&&!(array3[i].equalsIgnoreCase(dic[j1]))) {
					 
				for (int j2 = 0; j2 < array3[i].length(); j2++) {
					
					if(array3[i].charAt(j2)==dic[j1].charAt(j2)) {
						
						counter++;
					}
					else {
					if(flag) {
						index=j2;
						flag=false;
					}
						
					else {
						index1=j2;
					}
						
					}
				
				}
				
				flag=true;
				
				if(counter==array3[i].length()-2) {
				String temp3="";		
				char[]carray=new char[array3[i].length()];
				carray=array3[i].toCharArray();
						char temp2 = carray[index];
						carray[index]=carray[index1];
						carray[index1]=temp2;
				
				for (int j = 0; j < carray.length; j++) {
					temp3=temp3+carray[j];
					
				}

				if(temp3.equalsIgnoreCase(dic[j1])) {
					for (int j = 0; j < questions.length; j++) {
						if(questions[j].contains(array3[i])) {
							questions[j]=questions[j].replace(array3[i],dic[j1]);
						}
						
					}
				 }
				else
					temp3="";
				}
				 
				 }
			
				counter=0;
			 }
			}
		
		return questions;
	}
	
	static int stopwc(String[]array2,String[]stop) {
		int counter=0;
		boolean fl=true;
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < stop.length; j++) {
				if(array2[i].length()==stop[j].length()) {
				if(array2[i].equalsIgnoreCase(stop[j])) {
					
					fl=false;
					break;
					
				}
				else {
					fl=true;
				}
			}
			}
			if(fl==true&&!(array2[i].equalsIgnoreCase(null))&&array2[i]!="")
				counter++;
		}
		return counter;
				
	}
	
	   
	    
	
	public static void main(String[] args) throws Exception {
		SetCursor setcursor = new SetCursor();
		boolean DoubleDip = false;
		boolean fiftypercent = false;
		String DoubleDipHUD = "DoubleDip";
		String fiftypercentHUD = "50%";
		String answerinput="";
		
		int ParticipantCount=0;
		Participant Participant = null; 
		QuestionList QuestionList = null;
		Date[] participantDates= new Date[100];
		Address[] participantAddresses= new Address[100];
		Phone[] participantPhones= new Phone[100];
		String questionsfile= "sorular";
		int[] Moneys = null;
		String[] QuestionCatTrue= null;
		String[] QuestionCatFalse= null;
		int[]true_counter=new int[21];
		int truecounter =0;
		int falsecounter =0;
		
		
		
		Menu();
		Scanner scanner= new Scanner (System.in);
		
		
		String[]cat1=new String[15];
		String[]cat2=new String[15];
		String[]cat3=new String[15];
		String[]cat4=new String[15];
		String[]cat5=new String[15];
		String []questions=new String [15];
		String []categories=new String[15];
		int []qnumber=new int [15];
		int dicsize=arraySize("dictionary.txt");
		int stopsize=arraySize("stop_words.txt");
		String []dic=new String[dicsize];
		String []stop=new String[stopsize];
		int counter1=0;
		int counter2=0;
		int counter3=0;
		int counter4=0;
		int counter5=0;
		int c_1=1;
		int counter=0;
		
		int c=0;
		while(true) {
			System.out.print("> Enter your choice: ");
			int choice=scanner.nextInt();
		switch(choice) {
		case 1:

			
			System.out.println("> Enter file name to load: ");
			questionsfile=scanner.next();		
			
			int quesarray=arraySize(questionsfile);
			questions=new String [quesarray];
			questions=Reading(questions,questionsfile);
		    QuestionList= new QuestionList(questions.length);
		    QuestionCatTrue = new String[questions.length];
		    QuestionCatFalse = new String[questions.length];
			for (int i = 0; i < questions.length; i++) {
                
                String []hashtag =questions[i].split("#");
               
                
                QuestionList.addQuestion(new Question(hashtag[0],hashtag[1],hashtag[2],hashtag[3],hashtag[4],hashtag[5],hashtag[6],hashtag[7]));
                
            }
           
			System.out.println("Questions loaded");
			
			
			counter1=Counter("1",counter1,questions);
			counter2=Counter("2",counter2,questions);
			counter3=Counter("3",counter3,questions);
			counter4=Counter("4",counter4,questions);
			counter5=Counter("5",counter5,questions);
			cat1=new String[counter1];
			cat2=new String[counter2];
			cat3=new String[counter3];
			cat4=new String[counter4];
			cat5=new String[counter5];
			boolean flag=false;
			int index2=questions[0].indexOf("#");
			String categorie2=questions[0].substring(0,index2);
			categories[0]=categorie2;
			
			for (int i = 0;i<questions.length;i++) 
				
			{
				counter=0;
				String temp=questions[i];
				int index=temp.indexOf("#");
				String categorie=temp.substring(0,index);
				
				for (int j = 0; j < c_1; j++) {
					if (!(categorie.equalsIgnoreCase(categories[j]))) {
						
						flag=true;
						
					}
					else {
						flag=false;
						break;
					}
						
					
					
				}
				if(flag) {
					categories[c_1]=categorie;
					c_1++;
				}
			}
			for (int i = 0; i <c_1; i++) {
				for (int j = 0; j < questions.length; j++) {
					if(questions[j].startsWith(categories[i])){
						counter++;
					}
					
				}
				qnumber[c]=counter;
				c++;
				counter=0;
				
			}
			
			
			System.out.println("Category              The number of questions");
			for(int k = 0;k<c_1;k++) {
			
			
			System.out.println(categories[k]+"                "+qnumber[k]);
			
			}
			
			
			Printing(counter1,counter2,counter3,counter4,counter5);
			
		
			
			break;		
		
		case 2:
			String[]a=new String[21];
            String[]b=new String[4];
            String[]DateDetail=new String[3];
            String[]PhoneDetail=new String[3];
            String[]AddressDetail=new String[5];
            System.out.println("> Enter file name to load: ");
            String participantsfile=scanner.next();
            a=Reading(a,participantsfile);
            Participant= new Participant(a.length);
            Moneys = new int[a.length];
            

            for (int i = 0; i < a.length; i++) {
                a[i]=a[i].replace('.', ',');
                b=a[i].split("#");
                DateDetail=b[1].split(",");



                participantDates[i] = new Date( Integer.parseInt(DateDetail[0]), Integer.parseInt(DateDetail[1]), Integer.parseInt(DateDetail[2]));

            }
            for (int i = 0; i < a.length; i++) {
                a[i]=a[i].replace('.', ',');
                b=a[i].split("#");
                PhoneDetail=b[2].split(" ");



                participantPhones[i] = new Phone(PhoneDetail[0], PhoneDetail[1]+PhoneDetail[2]);

            }
            for (int i = 0; i < a.length; i++) {
                a[i]=a[i].replace('.', ',');
                b=a[i].split("#");
                AddressDetail=b[3].split(";");



                participantAddresses[i] = new Address(AddressDetail[0], AddressDetail[1],AddressDetail[2],AddressDetail[3],AddressDetail[4]);

            }
            for (int i = 0; i < a.length; i++) {
                a[i]=a[i].replace('.', ',');
                b=a[i].split("#");
                String Name = b[0];


                Participant.AddPerson(new Person(Name,participantDates[i],participantPhones[i],participantAddresses[i]));

            }
            System.out.println("Participants loaded");

	
			
		break;
		case 3:
			ParticipantCount = 0;
			int QuestionLevel =1;
			int Money =0;
	        boolean IsGameFinished = false;
	        truecounter=0;
		    falsecounter=0;
			dic=Reading(dic,"dictionary.txt");
			stop=Reading(stop,"stop_words.txt");
		
				questions=Reading(questions,questionsfile);
				System.out.println("Contestant: "+Participant.getParticipants()[ParticipantCount].getName());
			    System.out.println("");
			    cat1=cat(questions, cat1, "1");
				cat2=cat(questions, cat2, "2");
				cat3=cat(questions, cat3, "3");
				cat4=cat(questions, cat4, "4");
				cat5=cat(questions, cat5, "5");
				String tempr1=wordc(cat1);
				String tempr2=wordc(cat2);
				String tempr3=wordc(cat3);
				String tempr4=wordc(cat4);
				String tempr5=wordc(cat5);
				
				int counter11=blank(tempr1);
				int counter22=blank(tempr2);
				int counter33=blank(tempr3);
				int counter44=blank(tempr4);
				int counter55=blank(tempr5);
				String[] cat11=new String[counter11];
				String[] cat22=new String[counter22];
				String[] cat33=new String[counter33];
				String[] cat44=new String[counter44];
				String[] cat55=new String[counter55];
				cat11=tempr1.split(" ");
				cat22=tempr2.split(" ");
				cat33=tempr3.split(" ");
				cat44=tempr4.split(" ");
				cat55=tempr5.split(" ");
				int counter111=stopwc(cat11, stop);
				int counter222=stopwc(cat22, stop);
				int counter333=stopwc(cat33, stop);
				int counter444=stopwc(cat44, stop);
				int counter555=stopwc(cat55, stop);
				String[]cat_1=new String[counter111];
				String[]cat_2=new String[counter222];
				String[]cat_3=new String[counter333];
				String[]cat_4=new String[counter444];
				String[]cat_5=new String[counter555];
				cat_1=stopw(cat11,stop,cat_1);
				cat_2=stopw(cat22,stop,cat_2);
				cat_3=stopw(cat33,stop,cat_3);			
				cat_4=stopw(cat44,stop,cat_4);
				cat_5=stopw(cat55,stop,cat_5);
				int counter1111=wrongcounter(cat_1, dic);
				int counter2222=wrongcounter(cat_2, dic);
				int counter3333=wrongcounter(cat_3, dic);
				int counter4444=wrongcounter(cat_4, dic);
				int counter5555=wrongcounter(cat_5, dic);
				String[]wrong1=new String[counter1111];
				String[]wrong2=new String[counter2222];
				String[]wrong3=new String[counter3333];
				String[]wrong4=new String[counter4444];
				String[]wrong5=new String[counter5555];
				wrong1=wrong(cat_1, dic,wrong1);
				wrong2=wrong(cat_2, dic,wrong2);
				wrong3=wrong(cat_3, dic,wrong3);
				wrong4=wrong(cat_4, dic,wrong4);
				wrong5=wrong(cat_5, dic,wrong5);
				if(counter1111>0) {
					questions=wcloud(questions, dic, wrong1);
					questions=reversed(wrong1, dic, questions);
				}
				if(counter2222>0) {
				questions=wcloud(questions, dic, wrong2);
				questions=reversed(wrong2, dic, questions);
				}
				if(counter3333>0) {
				questions=wcloud(questions, dic, wrong3);
				questions=reversed(wrong3, dic, questions);
				}
				if(counter4444>0) {
				questions=wcloud(questions, dic, wrong4);
				questions=reversed(wrong4, dic, questions);
				}
				if(counter5555>0) {
				questions=wcloud(questions, dic, wrong5);
				questions=reversed(wrong5, dic, questions);
				}
				cat1=cat(questions, cat1, "1");
				cat2=cat(questions, cat2, "2");
				cat3=cat(questions, cat3, "3");
				cat4=cat(questions, cat4, "4");
				cat5=cat(questions, cat5, "5");
				tempr1=wordc(cat1);
				tempr2=wordc(cat2);
				tempr3=wordc(cat3);
				tempr4=wordc(cat4);
				tempr5=wordc(cat5);
				cat11=tempr1.split(" ");
				cat22=tempr2.split(" ");
				cat33=tempr3.split(" ");
				cat44=tempr4.split(" ");
				cat55=tempr5.split(" ");
				cat_1=stopw(cat11,stop,cat_1);
				cat_2=stopw(cat22,stop,cat_2);
				cat_3=stopw(cat33,stop,cat_3);
				cat_4=stopw(cat44,stop,cat_4);
				cat_5=stopw(cat55,stop,cat_5);
				for (int i = 0; i < QuestionList.getQuestioncount(); i++) {
					
					 String []hashtag =questions[i].split("#");
					 
				     QuestionList.getQuestionList()[i].setQuestion(hashtag[1]);
				}
				String[]Currentcloud = cat_1;
				int []CurrentcloudNum = null;
			    while(!IsGameFinished)
			    {
			    boolean Skip=false;
			    
			
				
			
				switch(QuestionLevel) {
				case 1:{
				int[]randomnum=new int [cat_1.length];
				randomnum=Random(randomnum,cat_1);
				CurrentcloudNum=randomnum;
				Cloud(randomnum,cat_1);
				Currentcloud = cat_1;
				break;
				}
				case 2:{
					int[]randomnum=new int [cat_2.length];
					randomnum=Random(randomnum,cat_2);
					CurrentcloudNum=randomnum;
					Cloud(randomnum,cat_2);
					Currentcloud = cat_2;
				break;
				}
				case 3:{
					int[]randomnum=new int [cat_3.length];
					randomnum=Random(randomnum,cat_3);
					CurrentcloudNum=randomnum;
					Cloud(randomnum,cat_3);
					Currentcloud = cat_3;
					break;
				}
				case 4:{
					int[]randomnum=new int [cat_4.length];
					randomnum=Random(randomnum,cat_4);
					CurrentcloudNum=randomnum;
					Cloud(randomnum,cat_4);
					Currentcloud = cat_4;
				break;
				}
				case 5:{
					int[]randomnum=new int [cat_5.length];
					randomnum=Random(randomnum,cat_5);
					CurrentcloudNum=randomnum;
					Cloud(randomnum,cat_5);
					Currentcloud = cat_5;
				break;
				}
				}
				int QuestionIndex=0;
				System.out.println("");
				System.out.println("Enter your selection");
			    
			    String wordcloudinput =scanner.next();
			    boolean cloudflag=false;
			    for(int i =0;i<questions.length;i++)
			    {   while(cloudflag==false) {
			    	for (int j = 0; j < 13; j++) {
			    		
						if(Currentcloud[CurrentcloudNum[j]].equalsIgnoreCase(wordcloudinput))
						{
							cloudflag=true;
							break;
						}
			    	}
			    	if(cloudflag)
			    	{
			    		break;
			    	}
			    	System.out.println("Please enter your word choice correct.");
			    	wordcloudinput =scanner.next();
			    	
						
					}
			    	
			    	if(QuestionList.getQuestionList()[i].getQuestion().contains(wordcloudinput)&&QuestionList.getQuestionList()[i].getLevel().equalsIgnoreCase(String.valueOf(QuestionLevel)))
			    	{   QuestionIndex=i;
			    	    System.out.println("---------------------------");
			    	    System.out.println("|      Money: "+Money+"                ");
			    	    System.out.println("| "+fiftypercentHUD+"           "+DoubleDipHUD+" ");
			    	    System.out.println("---------------------------");
			    		System.out.println(QuestionList.getQuestionList()[i].getLevel()+"-"+QuestionList.getQuestionList()[i].getQuestion());
			    		System.out.println("A) "+QuestionList.getQuestionList()[i].getAnswer1());
			    		System.out.println("B) "+QuestionList.getQuestionList()[i].getAnswer2());
			    		System.out.println("C) "+QuestionList.getQuestionList()[i].getAnswer3());
			    		System.out.println("D) "+QuestionList.getQuestionList()[i].getAnswer4());
			    		break;
			    	}
			    	
			    }
			    System.out.println("Enter your option(E:Exit)");	
			    
			    Thread timer = new Thread(() -> {
			    	
				    try {
				        for (int seconds = 20; seconds >= 0; seconds--) {
				        	CursorX = setcursor.cn.getTextWindow().getCursorX();
				        	setcursor.cn.getTextWindow().setCursorPosition(40,setcursor.cn.getTextWindow().getCursorY()-1);				        	
				            System.out.println("Time "+seconds+ " ");
				            setcursor.cn.getTextWindow().setCursorPosition(CursorX,setcursor.cn.getTextWindow().getCursorY());
				            
				            
				            
				            Thread.sleep(1000);			            
				        }
				        
				        System.out.println("Time's up!");
				        boolean timesup=true;
				        
				    }catch(InterruptedException weCanIgnoreThisException){}
				});
			   
			    timer.start();			    
			    answerinput =scanner.next();
				timer.interrupt();
			    if(answerinput.equalsIgnoreCase("E"))
			    {
			    	System.out.println("You lost!");
			    	switch(QuestionLevel)
			    	{
			    	case 1:
			    	{
			    	Money = 0;
			    	break;
			    	}
			    	case 2:
			    	{
			    	Money = 20000;
			    	break;
			    	}
			    	case 3:
			    	{
			    	Money = 100000;
			    	break;
			    	}
			    	case 4:
			    	{
			    	Money = 250000;
			    	break;
			    	}
			    	case 5:
			    	{
			    	Money = 500000;
			    	break;
			    	}
			    	}
			    	System.out.println("You won $"+Money);
			    	System.out.println("Next Constant? (Y/N)");
			    	if(truecounter>0)
			    	true_counter[ParticipantCount]=truecounter;
			    	Moneys[ParticipantCount] = Money;
			    	String constantinput =scanner.next();
			    	if(constantinput.equalsIgnoreCase("Y"))
			    	{
			    		ParticipantCount++;
			    		fiftypercent = false;
			    		DoubleDip = false;
			    		fiftypercentHUD="50%";
			    		DoubleDipHUD = "DoubleDip";
			    		QuestionLevel =1;
						Money =0;
						truecounter=0;
			    		if(Participant.getCount()==ParticipantCount)
				    	{
				    		ParticipantCount=0;
				    	}
			    		System.out.println("Contestant: "+Participant.getParticipants()[ParticipantCount].getName());
					    System.out.println("");
			    	}
			    	else {
			    		Menu();
			    		break;
			    	}
			    	
			    	
			    }
			    
			    else {
			    	if(answerinput.equalsIgnoreCase("50%")&&fiftypercent==false)
				    {
				    	fiftypercent =true;
				    	fiftypercentHUD="";
				    	switch(QuestionList.getQuestionList()[QuestionIndex].getTrueOption())
				    	{
				    	case "A":
				    		
				    		System.out.println("---------------------------------");
				    	    System.out.println("|      Money: "+Money +"     ");
				    	    System.out.println("| "+fiftypercentHUD+"           "+DoubleDipHUD+"   ");
				    	    System.out.println("---------------------------------");
				    		System.out.println(QuestionList.getQuestionList()[QuestionIndex].getLevel()+"-"+QuestionList.getQuestionList()[QuestionIndex].getQuestion());
				    		System.out.println("A) "+QuestionList.getQuestionList()[QuestionIndex].getAnswer1());
				    		System.out.println("B) ");
				    		System.out.println("C) ");
				    		System.out.println("D) "+QuestionList.getQuestionList()[QuestionIndex].getAnswer4());
				    		System.out.println("Enter your option(E:Exit)");
						    answerinput =scanner.next();
						    break;
				    		
				    	case "B":
				    		System.out.println("---------------------------------");
				    	    System.out.println("|      Money: "+Money +"      ");
				    	    System.out.println("| "+fiftypercentHUD+"           "+DoubleDipHUD+"   ");
				    	    System.out.println("---------------------------------");
				    		System.out.println(QuestionList.getQuestionList()[QuestionIndex].getLevel()+"-"+QuestionList.getQuestionList()[QuestionIndex].getQuestion());
				    		System.out.println("A) ");
				    		System.out.println("B) "+QuestionList.getQuestionList()[QuestionIndex].getAnswer2());
				    		System.out.println("C) "+QuestionList.getQuestionList()[QuestionIndex].getAnswer3());
				    		System.out.println("D) ");
				    		System.out.println("Enter your option(E:Exit)");
						    answerinput =scanner.next();
				    	    break;
				    	case "C":
				    		System.out.println("---------------------------------");
				    	    System.out.println("|      Money: "+Money +"    ");
				    	    System.out.println("| "+fiftypercentHUD+"           "+DoubleDipHUD+"   ");
				    	    System.out.println("---------------------------------");
				    		System.out.println(QuestionList.getQuestionList()[QuestionIndex].getLevel()+"-"+QuestionList.getQuestionList()[QuestionIndex].getQuestion());
				    		System.out.println("A) ");
				    		System.out.println("B) "+QuestionList.getQuestionList()[QuestionIndex].getAnswer2());
				    		System.out.println("C) "+QuestionList.getQuestionList()[QuestionIndex].getAnswer3());
				    		System.out.println("D) ");
				    		System.out.println("Enter your option(E:Exit)");
						    answerinput =scanner.next();
				    	    break;
				    	case "D":
				    		System.out.println("---------------------------------");
				    	    System.out.println("|      Money: "+Money +"      ");
				    	    System.out.println("| "+fiftypercentHUD+"           "+DoubleDipHUD+"   ");
				    	    System.out.println("---------------------------------");
				    		System.out.println(QuestionList.getQuestionList()[QuestionIndex].getLevel()+"-"+QuestionList.getQuestionList()[QuestionIndex].getQuestion());
				    		System.out.println("A) "+QuestionList.getQuestionList()[QuestionIndex].getAnswer1());
				    		System.out.println("B) ");
				    		System.out.println("C) ");
				    		System.out.println("D) "+QuestionList.getQuestionList()[QuestionIndex].getAnswer4());
				    		System.out.println("Enter your option(E:Exit)");
						    answerinput =scanner.next();
				    	}
				    	if(answerinput.equalsIgnoreCase("E"))
					    {
					    	System.out.println("You lost!");
					    	switch(QuestionLevel)
					    	{
					    	case 1:
					    	{
					    	Money = 0;
					    	break;
					    	}
					    	case 2:
					    	{
					    	Money = 20000;
					    	break;
					    	}
					    	case 3:
					    	{
					    	Money = 100000;
					    	break;
					    	}
					    	case 4:
					    	{
					    	Money = 250000;
					    	break;
					    	}
					    	case 5:
					    	{
					    	Money = 500000;
					    	break;
					    	}
					    	}
					    	System.out.println("You won $"+Money);
					    	System.out.println("Next Constant? (Y/N)");
					    	if(truecounter>0)
					    	true_counter[ParticipantCount]=truecounter;
					    	Moneys[ParticipantCount] = Money;
					    	String constantinput =scanner.next();
					    	if(constantinput.equalsIgnoreCase("Y"))
					    	{
					    		ParticipantCount++;
					    		fiftypercent = false;
					    		DoubleDip = false;
					    		fiftypercentHUD="50%";
					    		DoubleDipHUD = "DoubleDip";
					    		Skip=true;
					    		QuestionLevel =1;
								Money =0;
								truecounter=0;
					    		if(Participant.getCount()==ParticipantCount)
						    	{
						    		ParticipantCount=0;
											  	
						    	}
					    		System.out.println("Contestant: "+Participant.getParticipants()[ParticipantCount].getName());
							    System.out.println("");
					    	}
					    	else {
					    		Menu();
					    		break;
					    	}
					    	
					    	
					    }
				    }
			    	if(answerinput.equalsIgnoreCase("DoubleDip")&&DoubleDip==false)
				    {
				    	DoubleDip=true;
				    	DoubleDipHUD="";
				    	System.out.println("DoubleDip activated");
				    	answerinput = scanner.next();
				    	if(answerinput.equalsIgnoreCase("E"))
					    {
					    	System.out.println("You lost!");
					    	switch(QuestionLevel)
					    	{
					    	case 1:
					    	{
					    	Money = 0;
					    	break;
					    	}
					    	case 2:
					    	{
					    	Money = 20000;
					    	break;
					    	}
					    	case 3:
					    	{
					    	Money = 100000;
					    	break;
					    	}
					    	case 4:
					    	{
					    	Money = 250000;
					    	break;
					    	}
					    	case 5:
					    	{
					    	Money = 500000;
					    	break;
					    	}
					    	}
					    	System.out.println("You won $"+Money);
					    	System.out.println("Next Constant? (Y/N)");
					    	if(truecounter>0)
					    	true_counter[ParticipantCount]=truecounter;
					    	Moneys[ParticipantCount] = Money;
					    	String constantinput =scanner.next();
					    	if(constantinput.equalsIgnoreCase("Y"))
					    	{
					    		ParticipantCount++;
					    		fiftypercent = false;
					    		DoubleDip = false;
					    		fiftypercentHUD="50%";
					    		DoubleDipHUD = "DoubleDip";
					    		Skip=true;
					    		QuestionLevel =1;
								Money =0;
								truecounter=0;
					    		if(Participant.getCount()==ParticipantCount)
						    	{
						    		ParticipantCount=0;
											  	
						    	}
					    		System.out.println("Contestant: "+Participant.getParticipants()[ParticipantCount].getName());
							    System.out.println("");
					    	}
					    	else {
					    		Menu();
					    		break;
					    	}
					    	
					    	
					    }
				    	
				    	if(answerinput.equalsIgnoreCase(QuestionList.getQuestionList()[QuestionIndex].getTrueOption()))
					    {
				    		QuestionCatTrue[truecounter]=QuestionList.getQuestionList()[QuestionIndex].getCategory();
					    	truecounter++;
					    	if(QuestionLevel<5) {
					    	System.out.println("Correct Answer!,moving to the new question");
					    	System.out.println("");
					    	
					    	
					    	
					    	switch(QuestionLevel)
					    	{
					    	case 1:
					    	{
					    	Money = 20000;
					    	break;
					    	}
					    	case 2:
					    	{
					    	Money = 100000;
					    	break;
					    	}
					    	case 3:
					    	{
					    	Money = 250000;
					    	break;
					    	}
					    	case 4:
					    	{
					    	Money = 500000;
					    	break;
					    	}
					    	
					    	}
					      	QuestionLevel++;
					      	Skip =true;
					    	
					    	}
					    	else {
					    		Money = 1000000;
					    		System.out.println("Congrulations you answered all questions!");
					    		System.out.println("You won $"+Money);
					    		System.out.println("Next Constant? (Y/N)");
					    		if(truecounter>0)
					    		true_counter[ParticipantCount]=truecounter;
					    		Moneys[ParticipantCount] = Money;
						    	String constantinput =scanner.next();
						    	
						    	if(constantinput.equalsIgnoreCase("Y"))
						    	{
						    		ParticipantCount++;
						    		fiftypercent = false;
						    		DoubleDip= false;
						    		fiftypercentHUD="50%";
						    		DoubleDipHUD = "DoubleDip";
						    		QuestionLevel =1;
									Money =0;
									truecounter=0;
						    		if(Participant.getCount()==ParticipantCount)
							    	{
							    		ParticipantCount=0;
							    	}
						    		System.out.println("Contestant: "+Participant.getParticipants()[ParticipantCount].getName());
								    System.out.println("");
						    	}
						    	else {
						    		Menu();
						    		break;
						    	}
					    	
					    		
					    	}
					      	
					    }
				    	else {
				    		System.out.println("Wrong answer,Please make your second choice!");
				    		QuestionCatFalse[falsecounter]=QuestionList.getQuestionList()[QuestionIndex].getCategory();
					    	falsecounter++;
				    		answerinput=scanner.next();
				    	}
				    	
				    	
				    }
				    
			  if(!Skip) {  
			    if(answerinput.equalsIgnoreCase(QuestionList.getQuestionList()[QuestionIndex].getTrueOption()))
			    {   QuestionCatTrue[truecounter]=QuestionList.getQuestionList()[QuestionIndex].getCategory();
		    	    truecounter++;
			    	if(QuestionLevel<5) {
			    	System.out.println("Correct Answer!,moving to the new question");
			    	System.out.println("");
			    	
			    	
			    	switch(QuestionLevel)
			    	{
			    	case 1:
			    	{
			    	Money = 20000;
			    	break;
			    	}
			    	case 2:
			    	{
			    	Money = 100000;
			    	break;
			    	}
			    	case 3:
			    	{
			    	Money = 250000;
			    	break;
			    	}
			    	case 4:
			    	{
			    	Money = 500000;
			    	break;
			    	}
			    	
			    	}
			      	QuestionLevel++;
			    	
			    	}
			    	else {
			    		Money = 1000000;
			    		System.out.println("Congrulations you answered all questions!");
			    		System.out.println("You won $"+Money);
			    		System.out.println("Next Constant? (Y/N)");
			    		if(truecounter>0)
			    		true_counter[ParticipantCount]=truecounter;
			    		Moneys[ParticipantCount] = Money;
				    	String constantinput =scanner.next();
				    	
				    	if(constantinput.equalsIgnoreCase("Y"))
				    	{
				    		ParticipantCount++;
				    		fiftypercent = false;
				    		DoubleDip= false;
				    		fiftypercentHUD="50%";
				    		DoubleDipHUD = "DoubleDip";
				    		QuestionLevel =1;
							Money =0;
							truecounter=0;
				    		if(Participant.getCount()==ParticipantCount)
					    	{
					    		ParticipantCount=0;
					    	}
				    		System.out.println("Contestant: "+Participant.getParticipants()[ParticipantCount].getName());
						    System.out.println("");
				    	}
				    	else {
				    		Menu();
				    		break;
				    	}
			    	
			    		
			    	}
			      	
			    }
			    else
			    {
			    	System.out.println("True answer was "+QuestionList.getQuestionList()[QuestionIndex].getTrueOption() +",You lost");
			    	QuestionCatFalse[falsecounter]=QuestionList.getQuestionList()[QuestionIndex].getCategory();
			    	falsecounter++;
			    	switch(QuestionLevel)
			    	{
			    	case 2:
			    	{
			    	Money = 0;
			    	break;
			    	}
			    	case 3:
			    	{
			    	Money = 100000;
			    	break;
			    	}
			    	case 4:
			    	{
			    	Money = 100000;
			    	break;
			    	}
			    	case 5:
			    	{
			    	Money = 500000;
			    	break;
			    	}
			    	
			    	}
			    	System.out.println("You won $"+Money);
			    	System.out.println("Next Constant? (Y/N)");
			    	if(truecounter>0)
			    	true_counter[ParticipantCount]=truecounter;
			    	Moneys[ParticipantCount] = Money;
			    	String constantinput =scanner.next();
			    	
			    	if(constantinput.equalsIgnoreCase("Y"))
			    	{
			    		ParticipantCount++;
			    		fiftypercent = false;
			    		DoubleDip = false;
			    		fiftypercentHUD="50%";
			    		DoubleDipHUD = "DoubleDip";
			    		QuestionLevel =1;
						Money =0;
						truecounter=0;
			    		if(Participant.getCount()==ParticipantCount)
				    	{
				    		ParticipantCount=0;
				    	}
			    		System.out.println("Contestant: "+Participant.getParticipants()[ParticipantCount].getName());
					    System.out.println("");
			    	}
			    	else {
			    		Menu();
			    		break;
			    	}

			    	
			    
			    }
			    }
			    }
			    }
				break;
		case 4:
		{
			int x=0;
			int max=-1;
			for (int i = 0; i < Moneys.length; i++) {
				
				if(Moneys[i]>max)
				{
					max = Moneys[i];
				    x =i;
				}
				
			}
			System.out.println("The most successful contestant: "+Participant.getParticipants()[x].getName());
			max=-1;
			
			String temptrue ="";
			int counterist =0;
			for (int i = 0; i < truecounter; i++) {
				
				for (int j = 0; j < truecounter; j++) {
					if(QuestionCatTrue[i].equalsIgnoreCase(QuestionCatTrue[j]))
					{
						counterist++;
				}
					
			}
				if(counterist>max)
				{
					max=counterist;
					temptrue = QuestionCatTrue[i];
				}
				counterist=0;
            
 
			}
			System.out.println("The category with the most correctly answered: "+temptrue );
			int min=1000;
			String tempfalse ="";
			int counteristfalse =0;
			for (int i = 0; i < falsecounter; i++) {
				
				for (int j = 0; j < falsecounter; j++) {
					if(QuestionCatFalse[i].equalsIgnoreCase(QuestionCatFalse[j]))
					{
						counteristfalse++;
				}
					
			}
				if(min>counteristfalse)
				{
					max=counteristfalse;
					tempfalse = QuestionCatFalse[i];
				}
				counteristfalse=0;
            
 
			}
			
			System.out.println("The category with the most badly answered: "+tempfalse );
			
			int current_year=2022;
			double age1=0;
			double age2=0;
			double age3=0;
			int counter_age1=0;
			int counter_age2=0;
			int counter_age3=0;
						
			for (int i = 0; i < ParticipantCount; i++) {
				int age=current_year-Participant.getParticipants()[i].getDate().getYear();
				if(age<=30) {
					age1=age1+ (double)true_counter[i]/5;
					counter_age1++;
				}
				else if (age>30 && age <=50) {
					age2=age2+ (double)true_counter[i]/5;	
					counter_age2++;
				}
				else {
					age3=age3+ (double)true_counter[i]/5;		
					counter_age3++;
				}
			}
			
			System.out.println("Age<=30 "+ age1/counter_age1  + " 30<Age<=50 " +  age2/counter_age2+" Age>50 "+age3/counter_age3);
			
			
			int Max=0;
            int Min=0;
            x=0;
            String statistic="";
            
            for (int i = 0; i < ParticipantCount; i++) {
            Min=0;
            statistic=Participant.getParticipants()[i].getAddress().getCity();
                for (int j = 0; j < ParticipantCount; j++) {
                    if(Participant.getParticipants()[j].getAddress().getCity().equalsIgnoreCase(statistic))
                        Min++;
                }
                if(Min>Max) {
                    Max=Min;
                    x=i;
                }
            }            
            
            System.out.println("The city with the highest number of participants: "+ Participant.getParticipants()[x].getAddress().getCity());
		}
			    
		case 5:
		{
			System.exit(0);
		}
				}
		}
		}
	}