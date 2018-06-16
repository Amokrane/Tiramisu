FORMAT: 1A

# Tiramisu

API specification for the Tiramisu project.

# Group Organization

Resources related to organizations in the API.

An Organization has the following attributes

+ name
+ url

## Organizations [/organizations]

### Create an Organization [POST]

+ Response 201 (application/json)

	+ Headers
		{
			"Location": "/organizations/1"
		}

	+ Body
		{
			"id": 1
		}


## List All TestRooms in an Organization [/organizations/{organization_id}/testrooms]

### List All TestRooms in an Organization [GET]

+ Response 200 (application/json)
	{
		"testrooms": [
			{
				"url": "/organizations/1/testrooms/2"
				"created_at":"2012-11-01T12:00:00"
			},			
			{
				"url": "/organizations/1/testrooms/2"
				"created_at":"2012-11-01T12:00:00"
			}
		]
	}

## Get TestRoom Details [/organizations/{organization_id}/testrooms/{testroom_id}]

### Get a TestRoom Detail [GET] 

+ Response 200 (application/json)
	{
		"name": "War Room for version 1.0.0 of the Android client"
		"owner": 123
		"created_at": "2018-10-01T12:00:00"
		"feedbacks": [
			{
				"url": "/testrooms/1/feedbacks/1",
				"resource_url": "http://d111111abcdef8.cloudfront.net/images/image.jpg",
				"shared_at": "2012-01-01T12:00:00",
				"votes": 10,
				"author": 10123,
				"message": "The Font on this page is incorrect"
			},
			{
				"url": "/testrooms/1/feedbacks/2",
				"resource_url": "http://d111111abcdef8.cloudfront.net/images/image.jpg",
				"shared_at": "2012-11-01T12:00:00",
				"votes": 1, 
				"author": 102,
				"message": "Cannot click on the blue button""
			}
		]
	}

### Create a TestRoom [POST]

+ name (string) - The name given to the TestRoom (for instance: UX Feedbacks on Registration Flow)

+ Request (application/json)
	{
		"name":  "UX Feedbacks on Registration Flow"
	}

+ Response 201 (application/json)

	+Headers
		{
			"Location": "/organizations/1/testrooms/1"
		}	
	

## Get TestRoom Summary [/organizations/{organization_id}/testrooms/{testroom_id}/summary]

### Get TestRoom Summary [GET]

	+ Response 200 (application/json)
		{
			"name": "War Room for version 1.0.0 of the Android Client"
			"owner": 123
			"created_at": "2018-10-01T12:00:00"
		}

## Feedback [organizations/{organization_id}/testrooms/{testroom_id}/feedbacks/{feedback_id}] 

+ Parameters
	+ organization_id: 1 (required, number) - ID of the organization the TestRoom belongs to
	+ testroom_id: 1 (required, number) - ID of the TestRoom in the form of an integer
	+ feedback_id: 1 (required, number) - ID of the Feedback in form of an integer

### View a Feedback [GET]

### Vote on a Feedback [POST]

 + Request (application/json)
	+ Attributes
		+ voter_id: 1 (required, number) - ID of the voter (current user)
		
 + Response 201 (application/json)
	
	+ Headers
		Location: /feedbacks/1


## Invitations [/organizations/{organization_id}/testrooms/{testroom_id}/invitations]

### List All Invitations [GET]

+ Reponse 200 (application/json)
	{
		"invitations": [
			{
				"inviter": 12,
				"invitee": 14
			}
		]
	}

### Create an Invitation [POST]

+ email (string) - The email that will receive the invitation to the TestRoom 

+ Request (application/json)
	{
		"email": "john.doe@example.com"
	}

+ Response 201 (application/json)

	+ Headers
		Location: /testrooms/1/invitations/13
	
	+ Body
		{
			"invitation_link": "http://someinvitationlink.example.com"
			"expiration_time": "2019-01-01T09:00:00"
		}

