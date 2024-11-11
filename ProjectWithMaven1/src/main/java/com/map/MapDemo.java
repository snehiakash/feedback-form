package com.map;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MapDemo {
public static void main(String[] args) {
	 Configuration cfg=new Configuration();
     cfg.configure ("hibernate.cfg.xml");
     SessionFactory factory=cfg.buildSessionFactory();
     
     //creating question.
     Question q1=new Question();
     q1.setQuestionId(1212);
     q1.setQuestion("What is Java?");
     
     //creating answer.
     Answer answer= new Answer();
     answer.setAnswerId(343);
     answer.setAnswer("Java Is a Programming Language");
     answer.setQuestion(q1);
    
     Answer answer1= new Answer();
     answer1.setAnswerId(33);
     answer1.setAnswer("With the Help of java we can create softwares");
     answer1.setQuestion(q1); 
  
     Answer answer2= new Answer();
     answer2.setAnswerId(363);
     answer2.setAnswer("Java Has Different Type of Framework");
     answer2.setQuestion(q1); 
     
     List<Answer> list= new ArrayList<Answer>();
     list.add(answer);
     list.add(answer1);
     list.add(answer2);
     
     q1.setAnswers(list);
     
     //session
     Session s=factory.openSession(); 
     Transaction tx=s.beginTransaction();
     
     //save
//     s.save(q1);
//     s.save(answer);
//     s.save(answer1);
//     s.save(answer2);
//     
    Question q= (Question)s.get(Question.class,1212);
     System.out.println(q1.getQuestionId());
     System.out.println(q1.getQuestion());
     System.out.println(q1.getAnswers().size());
     tx.commit();
//     //Fetching....
//     Question newQ= (Question)s.get(Question.class, 1212);
//     System.out.println(newQ.getQuestion());
//     System.out.println(newQ.getAnswer().getAnswer());
     s.close();
     
     factory.close();
}
}
