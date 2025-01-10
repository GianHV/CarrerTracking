package dto;

import java.util.ArrayList;
import java.util.List;

/**
 * The SchoolSection class represents a container that holds a list of schools
 * and sections. It has two attributes: a list of School objects and a list of
 * Section objects.
 *
 * @version 1.00
 * @author Huynh Van Giang
 */
public class SchoolSection {
	
	// List to store School objects, representing various schools.
	public List<School> schools = new ArrayList<School>();
	
	// List to store Section objects, representing different sections of a school.
	public List<Section> sections = new ArrayList<Section>();
}
