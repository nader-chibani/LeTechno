package edu.letechno.session;

import java.util.List;

import javax.ejb.Remote;

import edu.letechno.entity.Chapter;
@Remote
public interface IChapterSession {
	
	public Chapter AddChapter(Chapter e);
	public void DeleteChapter(Chapter e);
	public Chapter UpdateChapter(Chapter e);
	public List<Chapter> getChapterList(int CourseId);
	public Chapter getChapterById(int Chapterid );	
	
}
