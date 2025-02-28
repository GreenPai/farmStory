package kr.co.pamStory.service;

import java.util.Locale.Category;

import kr.co.pamStory.dao.CategoryDAO;
import kr.co.pamStory.dto.CategoryDTO;

public enum CategoryService {
	
	INSTANCE;
	
	private CategoryDAO dao = CategoryDAO.getInstance();

	public CategoryDTO findCateNo(String cateName) {
		return dao.selectcateNo(cateName);
	}
	
}
