
<liferay-ui:search-container emptyResultsMessage="empty-courses-results-message">
	<liferay-ui:search-container-results
		results="<%= CourseLocalServiceUtil.getCourses(searchContainer.getStart(), searchContainer.getEnd()) %>" 
		total= "<%= CourseLocalServiceUtil.getCoursesCount() %>"
	/>
	
	<liferay-ui:search-container-row
		className="com.ms3.training.services.model.Course"
		keyProperty="title"
		modelVar="Course" escapedModel="<%= true %>"
	>
		<liferay-ui:search-container-column-text
			name="name"
			value="<%= event.getName() %>"
		/>

		<liferay-ui:search-container-column-text
			name="description"
			property="description"
		/>

</liferay-ui:search-container>