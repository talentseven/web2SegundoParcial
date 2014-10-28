var author = {
		
		"init" : function(){
			author.methods.add();
		},
		
		"methods" : {
			
			"add" : function(){
				
				$('#author_add_btn').on('click', function(e){
					
					e.preventDefault();
					e.stopPropagation();
					
				    var firstName = $('#firstName').val(),
				    	lastName = $('#lastName').val();
				    
				    $.ajax({
				    	
				    	url: '/booksmov/app/authors/new',
				    	type: 'GET',
						data: {firstName: firstName, lastName: lastName},
						success: function(data){
							var data = $.parseJSON(data);
							console.log(data);
						},
						error: function(any, textStatus, errorThrown){
							console.log(textStatus + errorThrown + any);
						}

				    });
				   	
				});
			}/*,
			
			"listCourses" : function(){
				
				$('#view-courses').on('click', function(e){
					
					e.preventDefault();
					e.stopPropagation();
					
				    var studentId = $('#studentId').data('id'),
				    	courseId = $('#courseList option:selected').val();
				    
				    $.ajax({
				    	
				    	url: '../inscription/courses',
				    	type: 'POST',
						data: {studentId: studentId, courseId: courseId},
						success: function(data){
							var data = $.parseJSON(data);
							alert(data.message.description);
						},
						error: function(any, textStatus, errorThrown){
							console.log(textStatus + errorThrown + any);
						}

				    });
				   	
				});
			}
			*/
		}
};
