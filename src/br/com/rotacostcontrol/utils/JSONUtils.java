package br.com.rotacostcontrol.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.rotacostcontrol.model.entities.Category;
import br.com.rotacostcontrol.model.entities.Entry;
import br.com.rotacostcontrol.model.enums.EntryType;
import br.com.rotacostcontrol.services.json.CategoryJSON;
import br.com.rotacostcontrol.services.json.EntryJSON;

/**
 * 
 * @author bruno
 *
 */
public class JSONUtils {

	public static List<EntryJSON> convertListEntryForListEntryJSON(List<Entry> entries){
		
		List<EntryJSON> entriesJSON = new ArrayList<EntryJSON>();
		
		for(Entry entry : entries){

			EntryJSON entryJSON = convertEntryForEntryJSON(entry);
			entriesJSON.add(entryJSON);
		}
		
		return entriesJSON;
	}
	
	public static EntryJSON convertEntryForEntryJSON(Entry entry){
		
		EntryJSON entryJSON = new EntryJSON();
		entryJSON.setId(entry.getId());
		entryJSON.setCost(entry.getCost());
		entryJSON.setName(entry.getName());
		entryJSON.setType(entry.getType().toString());
		entryJSON.setDate(convertCalendarForStringDate(entry.getDate()));
		entryJSON.setCategoryName(entry.getCategory().getName());
		
		return entryJSON;
	}
	
	public static Entry convertEntryJSONForEntry(EntryJSON entryJSON) throws ParseException{
		
		Entry entry = new Entry();
		entry.setId(entryJSON.getId());
    	entry.setName(entryJSON.getName());
    	entry.setCost(entryJSON.getCost());
    	entry.setDate(convertStringDateForCalendar(entryJSON.getDate()));
    	
    	if("CREDIT".equals(entryJSON.getType())){
    		
        	entry.setType(EntryType.CREDIT);

    	}else{
    		
        	entry.setType(EntryType.DEBIT);
    	}
    	
		return entry;
	}
	
	private static Calendar convertStringDateForCalendar(String date) throws ParseException{
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(df.parse(date));
		
		return calendar;
	}
	
	private static String convertCalendarForStringDate(Calendar calendar){
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		String stringDate = df.format(calendar.getTime());
		
		return stringDate;
	}
	
	public static List<CategoryJSON> convertListCategoryForListCategoryJSON(List<Category> categories){
		
		List<CategoryJSON> categoriesJSON = new ArrayList<CategoryJSON>();
		
		for(Category category : categories){
			
			categoriesJSON.add(convertCategoryForCategoryJSON(category));
		}
		
		return categoriesJSON;
	}
	
	public static CategoryJSON convertCategoryForCategoryJSON(Category category){
		
		CategoryJSON categoryJSON = null;
		
		if(category != null){
			
			categoryJSON = new CategoryJSON();
			categoryJSON.setId(category.getId());
			categoryJSON.setName(category.getName());
		}
		
		return categoryJSON;
	}
}
