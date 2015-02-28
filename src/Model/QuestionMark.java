package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class QuestionMark extends LaneObject {

	public static int staminaPenalty = 0;

	public Question[] questions = new Question[4];

	public QuestionMark(int xLoc, int yLoc) throws IOException {
		this.xLoc=xLoc;
		this.yLoc=yLoc	;
		try {
			this.image = ImageIO.read(new File("images/qm.png.jpg"));
			BufferedReader reader = new BufferedReader(new FileReader("testingQuizQuestions.txt"));
			String line = null;
			int count = 0;
			ArrayList<String> inputs = new ArrayList<String>();
			while((line = reader.readLine()) != null){
				inputs.add(line);
				count ++;
				if(count == 7){
					count = 0;
					Question question= new Question(inputs);
					for(int i = 0; i < questions.length; i++){
						if(questions[i] == null){
							questions[i] = question;
							break;
						}
					}
					inputs.clear();

				}
			}
		}
		catch(FileNotFoundException F){
			F.printStackTrace();
		}
	}


	public String getQuestion(){
		return null;
	}

	public class Question {

		public String question;
		public ArrayList<String> answers = new ArrayList<String>();
		public String correctAnswer;
		public String statement;

		Question(ArrayList<String> ans){
			this.statement = ans.get(0);
			this.question = ans.get(1);
			this.correctAnswer = ans.get(2);
			for(int i = 2; i < ans.size(); i++){
				answers.add(ans.get(i));
			}
		}
		
		public String getStatement(){
			return this.statement;
		}

		public String getCorrectAnswer(){
			return this.correctAnswer;
		}

		public String getQuestion(){
			return this.question;
		}

		//		public void setAnswer(String answer){
		//			this.answer = answer;
		//		}

		public void setQuestion(String question){
			this.question = question;
		}
	}
}
