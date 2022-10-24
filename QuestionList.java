
public class QuestionList {
	private Question[] QuestionList;
	public static int questioncount;

	public QuestionList(int questions)
	{
		QuestionList= new Question[questions];
		questioncount=0;
		
	}
	public Question[] getQuestionList() {
		return QuestionList;
	}


	public static int getQuestioncount() {
		return questioncount;
	}
	
    public void addQuestion(Question q)
    {
    	QuestionList[questioncount] = q;
    	questioncount++;
    }
	
}
