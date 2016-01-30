package com.juby.toefl_speaking;

public class Topics {
	int n;
	
	Topics(int x){n=x;};
	Topics(){n=0;};	
	
	public String getTopic(int x){
		n=x;
		return s[n];
	} 
	public String shiftTopic(int i){
		n=((i+n)%s.length+s.length)%s.length;	
		
		return s[n];
	}
	
	String s[]={
			
			"Please descrip your hometown.",
				
			"Describe a book that you believe is the most useful to you. Please explain the reason and include specific examples and details in your explanation.",
	
			"Which of the following statements do your agree with? Please give specific reasons for your opinion. Some believe that TV programs have a positive influence on modern society. Others, however, think that the influence of TV programs is negative.",
	
			"Describe the most important decision that you have made in your life. Why was it important to you? Use specific examples and details to support your explanation.",
	
			"Some people believe that the high school should teach music and art as other basic science. Some people think that providing music and art education for high school students is not necessary. What is your opinion and why?",
	
			"What do you do in your spare time? Please include specific details in your statement.",
	
			"Some people think that it・s necessary to prohibit people from using phone calls in some places. Others believe that it・s inconvenient if phone calls are forbidden in some places. Which opinion do you prefer? Explain why. Your statement should include specific examples and details.",
	
			"Describe a celebration or moment which has made a deep impression on you. Please explain the impression and include specific examples and details in you explanation.",
	
			"Which of the following acts have more influence on you, newspaper, TV, or teachers? Explain the reason with specific details.",
			
			"Describe a social or politics celebration event in your culture. Specific examples and details are necessary in your statement.",
			
			"Whether the government should assist to build museum and theater? Give your opinion and include specific examples and details in your explanation.",
			
			"Describe a place that you like best in your city. Please state why you like it with specific examples and details.",
			
			"When you are together with your friends, which place would you like to go? Explain why.",
			
			"Do you like to eat at home or at the restaurant? Which do you prefer and explain the reason.",
			
			"Describe a public area that you visit frequently. Please state why you visit it frequently and include specific examples and details in your explanation.",
			
			"Some students prefer to choose universities located in big cities. Others would like to study in universities located in small towns. Please state your opinion and explain why.",
			
			"Usually, novels, magazines and poetry are considered the three major forms of literature. Which one do you prefer and explain why you prefer this literature form. Please include specific examples and details in your explanation.",
			
			"Some students tend to live alone, while others may want to share their rooms with their roommates. Which way of living do you think is better for students and why?",
			
			"When you are together with your friends, which place do you prefer to eat, the restaurant, cafe or at home? Use specific examples to support your statement.",
			
			"Some believe that computer have improved our lives while others think computers have caused a variety of problems. Which do you prefer? Please give your opinion and include specific examples and details.",
			
			"Describe the characteristics of a good teacher. Please state with specific examples and details.",
			
			"Some people prefer to work in the offices. Others would like to take the work to home. Which do you prefer and explain why.",
			
			"Who is the person you admire the most? Please give specific details and examples in your explanation.",
			
			"Some people believe that higher education is for all students. Other people believe that higher education is only suitable for certain students. Which opinion do you think is better and why?",
			
			"Do you agree or disagree with the following statement? Please give specific reasons for your opinion. Parents should restrict the TV programs that are watched by their kids instead of letting the kids watch TV programs freely.",
			
			"Describe the most efficient transportation in your country. Please state your reason and include specific examples and details in your explanation.",
			
			"Describe one of the most important inventions in recent 100 years. Explain why it is so important. Your explanation should include specific examples and details.",
			
			"Some believe that in comparison with those never attended college, people attended college will be more successful in career. Do you agree or disagree with this statement? Please give specific reasons for your opinion.",
			
			"Describe the characteristics of friends, use specific examples to support your statement.",
			
			"Someone suggests school to cut the Recycling. Do you agree or disagree with this suggestion, explain why.",
			
			"To be a leader or a follower, which do you prefer? Please give your opinion with specific examples and details.",
			
			"Which one do you think is better to help do research, internet or academic books? Explain why.",
			
			"Some believe that TV, newspaper and radio have more influence on individuals than their relatives and friends, while others believe not. Which statement do you prefer? Please give your opinion with specific examples and details.",
			
			"If you get a chance to choose a job, what will you do? What・s your reason for choosing this job? Please give your statement and include specific examples and details in your opinion.",
			
			"Would you like to take a long vacation or several short vacations in a year? Explain why.",
			
			"What do you think are the characteristics of a good parent?",
			
			"Do you prefer to study alone on work assignment from class or to study in groups?",
			
			"Everyone has a goal to fulfill. What・s your goal and explain why you want to fulfill this goal. Please include specific examples and details in your explanation.",
			
			"Describe one of your challenging experiences. Explain why it is challenging and how you conquered this challenge. Please include specific examples and details in your explanation.",
			
			"Some students would choose to study a subject because it brings plenty of job opportunities. Instead, others would choose to study a subject which really interests them, although it probably doesn・t sell well in the job market. Which opinion do you agree with? Explain why.",
			
			"Which is your favorite type of movie: action, drama, or others? Please include specific details and examples in your explanation.",
			
			"Choose one of your favorite methods to relax and explain why it is your favorite. Please include specific details in your explanation.",
			
			"Is it important for students to attend class regularly or study by oneself? Explain why.",
			
			"Describe a most happy event in your childhood. Please include specific examples and details in your explanation.",
			
			"Describe a school that you have attended.",
			
			"Some universities provide physical education. Others believe that physical education is not necessary. What do you think and why?",
			
			"Everyone has to leave home sometimes. What do you miss most when you are away from home? Please include specific examples and details in your explanation.",
			
			"Some people believe that we should help those in an emergency. Others think that we should first make clear of the situation, then decide whether to assist or not. What・s your opinion? Please include specific details in your explanation.",
			
			"Describe a special opportunity given to you. Why does this opportunity so special to you? Your explanation should include specific details and examples.",
			
			"What kind of qualities should a good leader possess?Please state your opinion and give specific details and examples in your explanation.",
			
			"Do you agree or disagree with the following statement? Please explain your opinion. People should always tell the truth.",

			"Describe an object which is very important to you and explain why it is of special value to you. Please include specific details in your explanation.",

			"Some people tend to judge a person on the basis of first observation. Some people believe it takes a long time to know a person well. Which approach to knowing people do you think is better and why?",

			"What kind of job would you like to choose? What・s your reason for choosing this job? Please include specific examples and details in your explanation.",

			"If you unexpectedly receive a large amount of money, what will you do with it? Would you spend it for practical purposes or simply for fun? State your opinion and explain your reasons.",

			"What do you think the students should do in their vocations? Please include specific examples and details in your statement.",

			"Describe an enjoyable event in your childhood. Why do you think it was enjoyable? Please include specific examples and details in your explanation.",

			"When communicating with your friends and families, you can rely on letters, email or telephone calls. Which method of communicating do you think is better and why?",

			"What is your best time in a year? Please state your reasons and include specific examples and details in your explanation.",

			"One should live a relaxed life instead of always hurrying. Do you agree or disagree which the above statement? Why or why nor? Use specific reasons and examples to support your answer.",

			"Describe your favorite room. Your statement should include specific examples and details.",
			
			"When travelling, some people prefer to reach the destination directly. Some others prefer to stop and look around the scenery along the way. What kindof way of travelling do you think is better and why?",
			
			"When you choose to eat at the restaurant or caffee, what are the features that you care about most? Explain why.",
			
			"Some believe that a city should keep its old buildings. Others think some new buildings are needed to replace the old buildings. What・s your opinion? Explain why.",
			
			"In case of problems, some prefer to get advice from family and friends. Others prefer to learn through personal experience. Which method is better and why?",
			
			"Do you agree or disagree: Students should wear uniform in school? Please include specific details and examples in your opinion."
			
			
	};
};
