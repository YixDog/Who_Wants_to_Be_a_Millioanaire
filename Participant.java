import java.util.Random;

public class Participant {
	public Person[] participants;
		
	public static int count;
	public static int randomcount =0;
	public static boolean flag =false;
	public static int []randomindexes;
	
	public Participant(int Participantscount) {
		participants = new Person[Participantscount];		
		count=Participantscount;
		randomindexes = new int[count];
		Random random=new Random();
		boolean flag =false;
		randomindexes= new int[count];
		int randomindex;
		for (int i = 0; i < randomindexes.length; i++) {
			randomindex=random.nextInt(count+1);
			flag=false;
			while(flag==false){
				flag=true;
				randomindex=random.nextInt(count+1);
			for (int j = 0; j < randomindexes.length; j++) {
				if(randomindex==randomindexes[j]||randomindex==0)
				{
					flag=false;
					break;
					
				}
				
			}
			
			
			}
			
			randomindexes[i]=randomindex;
		}
	}

	public Person[] getParticipants() {
		return participants;
	}

	public static int getCount() {
		return count;
	}
	
	public void AddPerson(Person p) {
		
		participants[randomindexes[randomcount]-1]=p;
		randomcount++;
		
				
	}

	
	
}
