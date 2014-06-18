jQuery.sap.require("sap.m.MessageBox");
jQuery.sap.require("sap.m.MessageToast");
jQuery.sap.require("jquery.sap.history");
jQuery.sap.require("sap.m.InstanceManager");
sap.ui.controller("skillsurvey-ui.app", {

/**
* Called when a controller is instantiated and its View controls (if available) are already created.
* Can be used to modify the View before it is displayed, to bind event handlers and do other one-time initialization.
* @memberOf skillsurvey-ui.app
*/
	onInit: function() {
		var view = this.getView();
		
		var data=	'{"Items":[{"viewName":"Individual"},{"viewName":"Supervisons"},{"viewName":"Department"},{"viewName":"RoleAssingments"},{"viewName":"Survey"},{"viewName":"Pathway"},{"viewName":"Role"},{"viewName":"Claim"},{"viewName":"ClaimAssingments"},{"viewName":"SurveyAnswer"},{"viewName":"Function"},{"viewName":"FunctionOccupations"},{"viewName":"Level"},{"viewName":"Occupation"},{"viewName":"Uoc"},{"viewName":"UocQuestion"},{"viewName":"Question"},{"viewName":"UocGroupMembers"},{"viewName":"UocGroup"},{"viewName":"Need"},{"viewName":"Dapssco"},{"viewName":"DapsscoLevels"},{"viewName":"DapsscoSkills"}]}';
		var oModel = new sap.ui.model.json.JSONModel();
		oModel.setJSON(data, false);
		sap.ui.getCore().setModel(oModel,"menuModel");

		this.app = view.app;

     	var bus = sap.ui.getCore().getEventBus();
		bus.subscribe("nav","to", this.navToHandler, this);
		bus.subscribe("nav","toEdit", this.navToEditHandler, this);
		bus.subscribe("nav","toDelete", this.navToDeleteHandler, this);
		bus.subscribe("nav","toCreate", this.navToCreateHandler, this);
		bus.subscribe("nav","toCreateSave", this.navToCreaeSaveHandler, this);
		bus.subscribe("nav","toOverview", this.navToOverviewHandler, this);
		bus.subscribe("nav","toEditSave", this.navToEditSaveHandler, this);
		bus.subscribe("nav","from", this.navToBackHandler, this);
		
		
		
	},
	navToDeleteHandler:function (channelId, EventId, data){
		this.serviceCallforDeleteRecord(data.id,this.app);
	},
	navToCreaeSaveHandler:function (channelId, EventId, data){
		this.serviceCallforSaveNewRecord(data.id,this.app);
	},
	navToEditSaveHandler:function (channelId, EventId, data){
		this.serviceCallforSaveEditRecrod(data.id,this.app);
	},
	navToOverviewHandler:function (channelId, EventId, data){
		//var myapp = this.app;
		if(data && data.id ){
		
		if(this.app.getDetailPage(data.id) === null){
			//jQuery.sap.log.info("Now Loading page'"+data.id+ "'", sDetails, sComponent)
			var newPage = sap.app.viewCache.get(data.id);
			this.app.addDetailPage(newPage);
		} 
		
	
		this.app.to(data.id, "slide");
		}

	},
	
	navToEditHandler : function (channelId, EventId, data){
		//var myapp = this.app;
		if(data && data.id ){
		
		if(this.app.getDetailPage(data.id) === null){
			//jQuery.sap.log.info("Now Loading page'"+data.id+ "'", sDetails, sComponent)
			var newPage = sap.app.viewCache.get(data.id);
			this.app.addDetailPage(newPage);
		} 
		//navigate
		this.app.to(data.id, "slide");
		}

	},
	navToCreateHandler : function (channelId, EventId, data){
		//var myapp = this.app;
		if(data && data.id ){
		
		if(this.app.getDetailPage(data.id) === null){
			//jQuery.sap.log.info("Now Loading page'"+data.id+ "'", sDetails, sComponent)
			var newPage = sap.app.viewCache.get(data.id);
			this.app.addDetailPage(newPage);
		} 
		//navigate
		this.app.to(data.id, "slide");
		}

	},
	navToHandler : function (channelId, EventId, data){
	
	//	var myapp = this.app;
		if(data && data.id ){
			this.serviceCallforInit(data.id,this.app);
		}
	},
	
	navToBackHandler : function (){
		alert("nav To Back");
	},
	
	serviceCallforInit : function(viewName,myapp){
		
		var serviceurl =sap.app.config.hostName+":"+sap.app.config.hostPort+"/"+sap.app.config.applicationContextPath;
		
		switch (viewName) {
		case 'Need':
			var oModel =sap.ui.getCore().getModel("overviewModel");
			if(oModel==null){
			 oModel = new sap.ui.model.json.JSONModel();
			}
			serviceurl=serviceurl+"need/managed";
			var data =[{"id":"RDB324","name":"xxxx","description":"yyyy"},{"id":"RDB32s","name":"xxxx","description":"yyyy"}];
		oModel.setData(data,false);
		oModel.setDefaultBindingMode("OneWay");
		sap.ui.getCore().setModel(oModel,"overviewModel");
		
		
		if(myapp.getDetailPage(viewName) === null){
			var newPage = sap.app.viewCache.get(viewName);
			myapp.addDetailPage(newPage);
		} 
		myapp.to(viewName, "slide");
		return;
			break;
			
		case 'Pathway':
			var oModel =sap.ui.getCore().getModel("overviewModel");
			if(oModel==null){
			 oModel = new sap.ui.model.json.JSONModel();
			}
			serviceurl=serviceurl+"pathway/managed";
			var uocjson =[{"id":"RDB213","name":"xxxx","description":"yyyy"},{"id":"RDB32s","name":"xxxx","description":"yyyy"}];
			oModel.setData(uocjson,false);
			oModel.setDefaultBindingMode("OneWay");
			sap.ui.getCore().setModel(oModel,"overviewModel");
			if(myapp.getDetailPage(viewName) === null){
				var newPage = sap.app.viewCache.get(viewName);
				myapp.addDetailPage(newPage);
			} 
			myapp.to(viewName, "slide");
			return;
			break;
			
		case 'Uoc':
			var oModel =sap.ui.getCore().getModel("overviewModel");
			if(oModel==null){
			 oModel = new sap.ui.model.json.JSONModel();
			}
			serviceurl=serviceurl+"uoc/managed";
			var uocjson =[{"id":"RDB234","name":"xxxx","description":"yyyy","type":"XXXX"},{"id":"RDB32s","name":"xxxx","description":"yyyy","type":"XXXX"}];
			oModel.setData(uocjson,false);
			oModel.setDefaultBindingMode("OneWay");
			sap.ui.getCore().setModel(oModel,"overviewModel");
			if(myapp.getDetailPage(viewName) === null){
				var newPage = sap.app.viewCache.get(viewName);
				myapp.addDetailPage(newPage);
			} 
			myapp.to(viewName, "slide");
			return;
			break;
			
		case 'Role':
			var oModel =sap.ui.getCore().getModel("overviewModel");
			if(oModel==null){
			 oModel = new sap.ui.model.json.JSONModel();
			}
			serviceurl=serviceurl+"role/managed";
			
			var rolejson =[{"id":"RDB23","name":"xxxx","description":"yyyy"},{"id":"RDB32s","name":"xxxx","description":"yyyy"}];
			oModel.setData(rolejson,false);
			oModel.setDefaultBindingMode("OneWay");
			sap.ui.getCore().setModel(oModel,"overviewModel");
			
			
			if(myapp.getDetailPage(viewName) === null){
				var newPage = sap.app.viewCache.get(viewName);
				myapp.addDetailPage(newPage);
			} 
			myapp.to(viewName, "slide");
			return;
			break;
			
		case 'Function':
			var oModel =sap.ui.getCore().getModel("overviewModel");
			if(oModel==null){
			 oModel = new sap.ui.model.json.JSONModel();
			}
			serviceurl=serviceurl+"function/managed";
			
			var functionjson =[{"id":"RDB23","name":"xxxx","description":"yyyy"},{"id":"RDB32s","name":"xxxx","description":"yyyy"}];
			oModel.setData(functionjson,false);
			oModel.setDefaultBindingMode("OneWay");
			sap.ui.getCore().setModel(oModel,"overviewModel");
			
			
			if(myapp.getDetailPage(viewName) === null){
				var newPage = sap.app.viewCache.get(viewName);
				myapp.addDetailPage(newPage);
			} 
			myapp.to(viewName, "slide");
			return;
			break;
			
		case 'Claim':
			var oModel =sap.ui.getCore().getModel("overviewModel");
			if(oModel==null){
			 oModel = new sap.ui.model.json.JSONModel();
			}
			serviceurl=serviceurl+"claim/managed";
			var claimjson =[{"id":"RDB12","code":"GHRS"},{"id":"RDB32","code":"XGHS"}];
			oModel.setData(claimjson,false);
			oModel.setDefaultBindingMode("OneWay");
			sap.ui.getCore().setModel(oModel,"overviewModel");
			
			
			if(myapp.getDetailPage(viewName) === null){
				var newPage = sap.app.viewCache.get(viewName);
				myapp.addDetailPage(newPage);
			} 
			myapp.to(viewName, "slide");
			return;
			break;
		case 'Level':
			var oModel =sap.ui.getCore().getModel("overviewModel");
			if(oModel==null){
			 oModel = new sap.ui.model.json.JSONModel();
			}
			serviceurl=serviceurl+"level/managed";
			var levelJson =[{"id":"RDB1","name":"xxxx","description":"yyyy"},{"id":"RDB32s","name":"xxxx","description":"yyyy"}];
			 var oModel = new sap.ui.model.json.JSONModel();
			oModel.setDefaultBindingMode("OneWay");
			oModel.setData(levelJson,false);
			sap.ui.getCore().setModel(oModel,"overviewModel");
             if(myapp.getDetailPage(viewName) === null){
				var newPage = sap.app.viewCache.get(viewName);
				myapp.addDetailPage(newPage);
			} 
			myapp.to(viewName, "slide");
			return;
			break;
		case 'Occupation':
			var oModel =sap.ui.getCore().getModel("overviewModel");
			if(oModel==null){
			 oModel = new sap.ui.model.json.JSONModel();
			}
			serviceurl=serviceurl+"occupation/managed";
			var occupationjson =[{"id":"RDB","name":"DFGR","description":"SDWER"},{"id":"RDB32s","name":"SDEF","description":"DFRGT"}];
			 var oModel = new sap.ui.model.json.JSONModel();
			oModel.setDefaultBindingMode("OneWay");
			oModel.setData(occupationjson,false);
			sap.ui.getCore().setModel(oModel,"overviewModel");
            if(myapp.getDetailPage(viewName) === null){
				var newPage = sap.app.viewCache.get(viewName);
				myapp.addDetailPage(newPage);
			} 
			myapp.to(viewName, "slide");
			return;
			break;
		case 'Question':
			var oModel =sap.ui.getCore().getModel("overviewModel");
			if(oModel==null){
			 oModel = new sap.ui.model.json.JSONModel();
			}
			serviceurl=serviceurl+"question/managed";
			var questionjson =[{"id":"RDB","text":"DFGR","style":"SDWER"},{"id":"RDB32s","text":"SDEF","style":"DFRGT"}];
			 var oModel = new sap.ui.model.json.JSONModel();
			oModel.setDefaultBindingMode("OneWay");
			oModel.setData(questionjson,false);
			sap.ui.getCore().setModel(oModel,"overviewModel");
           if(myapp.getDetailPage(viewName) === null){
				var newPage = sap.app.viewCache.get(viewName);
				myapp.addDetailPage(newPage);
			} 
			myapp.to(viewName, "slide");
			return;
			break;
		case 'Department':
			var oModel =sap.ui.getCore().getModel("overviewModel");
			if(oModel==null){
			 oModel = new sap.ui.model.json.JSONModel();
			}
			serviceurl=serviceurl+"department/managed";
			var departmentjson =[{"id":"RDB123","name":"xxxx","description":"yyyy","code":"XXXX"},{"id":"RDB32123","name":"xxxx","description":"yyyy","code":"XXXX"}];
			 var oModel = new sap.ui.model.json.JSONModel();
			oModel.setDefaultBindingMode("OneWay");
			oModel.setData(departmentjson,false);
			sap.ui.getCore().setModel(oModel,"overviewModel");
           if(myapp.getDetailPage(viewName) === null){
				var newPage = sap.app.viewCache.get(viewName);
				myapp.addDetailPage(newPage);
			} 
			myapp.to(viewName, "slide");
			return;
			break;
		case 'Supervisons':
			var oModel =sap.ui.getCore().getModel("overviewModel");
			if(oModel==null){
			 oModel = new sap.ui.model.json.JSONModel();
			}
			serviceurl=serviceurl+"supervisons/managed";
			var supervisonsjson =[{"supervisorId":"RDB123","supervisedId":"xxxx"},{"supervisorId":"RDB32123","supervisedId":"xxxx"}];
			 var oModel = new sap.ui.model.json.JSONModel();
			oModel.setDefaultBindingMode("OneWay");
			oModel.setData(supervisonsjson,false);
			sap.ui.getCore().setModel(oModel,"overviewModel");
           if(myapp.getDetailPage(viewName) === null){
				var newPage = sap.app.viewCache.get(viewName);
				myapp.addDetailPage(newPage);
			} 
			myapp.to(viewName, "slide");
			return;
			break;
		case 'ClaimAssingments':
			var oModel =sap.ui.getCore().getModel("overviewModel");
			if(oModel==null){
			 oModel = new sap.ui.model.json.JSONModel();
			}
			serviceurl=serviceurl+"claimassignments/managed";
			var claimassjson =[{"claimId":"RDB12","roleId":"GHRS"},{"claimId":"RDB32","roleId":"XGHS"}];
			oModel.setData(claimassjson,false);
			oModel.setDefaultBindingMode("OneWay");
			sap.ui.getCore().setModel(oModel,"overviewModel");
			
			
			if(myapp.getDetailPage(viewName) === null){
				var newPage = sap.app.viewCache.get(viewName);
				myapp.addDetailPage(newPage);
			} 
			myapp.to(viewName, "slide");
			return;
			break;
			
		case 'Dapssco':
			var oModel =sap.ui.getCore().getModel("overviewModel");
			if(oModel==null){
			 oModel = new sap.ui.model.json.JSONModel();
			}
			serviceurl=serviceurl+"dapssco/managed";
			var dapsscojson =[{"id":"RDBJJK","occupationId":"GHJHJ","levelId":"DGFGF"},{"id":"RDBJJK","occupationId":"GHJHJ","levelId":"DGFGF"},{"id":"RDBJJK","occupationId":"GHJHJ","levelId":"DGFGF"}];
			oModel.setData(dapsscojson,false);
			oModel.setDefaultBindingMode("OneWay");
			sap.ui.getCore().setModel(oModel,"overviewModel");
			
			
			if(myapp.getDetailPage(viewName) === null){
				var newPage = sap.app.viewCache.get(viewName);
				myapp.addDetailPage(newPage);
			} 
			myapp.to(viewName, "slide");
			return;
			break;
			
		case 'FunctionOccupations':
			var oModel =sap.ui.getCore().getModel("overviewModel");
			if(oModel==null){
			 oModel = new sap.ui.model.json.JSONModel();
			}
			serviceurl=serviceurl+"functionoccupations/managed";
			var functionoojson =[{"functionId":"RDBJJK","occupationId":"GHJHJ"},{"id":"RDBJJK","occupatioId":"GHJHJ"},{"id":"RDBJJK","occupatioId":"GHJHJ"}];
			oModel.setData(functionoojson,false);
			oModel.setDefaultBindingMode("OneWay");
			sap.ui.getCore().setModel(oModel,"overviewModel");
			
			
			if(myapp.getDetailPage(viewName) === null){
				var newPage = sap.app.viewCache.get(viewName);
				myapp.addDetailPage(newPage);
			} 
			myapp.to(viewName, "slide");
			return;
			break;
			
		case 'Individual':
			var oModel =sap.ui.getCore().getModel("overviewModel");
			if(oModel==null){
			 oModel = new sap.ui.model.json.JSONModel();
			}
			serviceurl=serviceurl+"individual/managed";
			var individualjson =[{"id":"RDB123","name":"xxxx","gender":"Male","loginPassword":"XXXX","departmentId":"DEHH","functionId":"FGFGFD","occupationId":"ODHGGD","levelId":"LHJJGH"}];
			oModel.setData(individualjson,false);
			oModel.setDefaultBindingMode("OneWay");
			sap.ui.getCore().setModel(oModel,"overviewModel");
			
			
			if(myapp.getDetailPage(viewName) === null){
				var newPage = sap.app.viewCache.get(viewName);
				myapp.addDetailPage(newPage);
			} 
			myapp.to(viewName, "slide");
			return;
			break;
			
		case 'Survey':
			var oModel =sap.ui.getCore().getModel("overviewModel");
			if(oModel==null){
			 oModel = new sap.ui.model.json.JSONModel();
			}
			serviceurl=serviceurl+"survey/managed";
			var individualjson =[{"id":"RDB123","individualId":"xxxx","dapssco_Id":"GHGJ","staredAt":"10/1/14","completedAt":"17/6/14","pathwayId":"FGFGFD"},{"id":"RDB123","individualId":"xxxx","dapssco_Id":"GHGJ","staredAt":"10/1/14","completedAt":"17/6/14","pathwayId":"FGFGFD"},{"id":"RDB123","individualId":"xxxx","dapssco_Id":"GHGJ","staredAt":"10/1/14","completedAt":"17/6/14","pathwayId":"FGFGFD"},{"id":"RDB123","individualId":"xxxx","dapssco_Id":"GHGJ","staredAt":"10/1/14","completedAt":"17/6/14","pathwayId":"FGFGFD"}];
			oModel.setData(individualjson,false);
			oModel.setDefaultBindingMode("OneWay");
			sap.ui.getCore().setModel(oModel,"overviewModel");
			
			
			if(myapp.getDetailPage(viewName) === null){
				var newPage = sap.app.viewCache.get(viewName);
				myapp.addDetailPage(newPage);
			} 
			myapp.to(viewName, "slide");
			return;
			break;
			
		case 'DapsscoLevels':
			var oModel =sap.ui.getCore().getModel("overviewModel");
			if(oModel==null){
			 oModel = new sap.ui.model.json.JSONModel();
			}
			serviceurl=serviceurl+"dapsscolevels/managed";
			var individualjson =[{"dapssco_id":"DFGFFGF","levelId":"GHJGFGH"},{"dapssco_id":"DFGFFGF","levelId":"GHJGFGH"},{"dapssco_id":"DFGFFGF","levelId":"GHJGFGH"}];
			oModel.setData(individualjson,false);
			oModel.setDefaultBindingMode("OneWay");
			sap.ui.getCore().setModel(oModel,"overviewModel");
			
			
			if(myapp.getDetailPage(viewName) === null){
				var newPage = sap.app.viewCache.get(viewName);
				myapp.addDetailPage(newPage);
			} 
			myapp.to(viewName, "slide");
			return;
			break;
			
		case 'DapsscoSkills':
			var oModel =sap.ui.getCore().getModel("overviewModel");
			if(oModel==null){
			 oModel = new sap.ui.model.json.JSONModel();
			}
			serviceurl=serviceurl+"dapsscoskills/managed";
			var dsjson =[{"dapssco_Id":"HFGHDD","uoc_GroupId":"TYRCC"},{"dapssco_Id":"HFGHDD","uoc_GroupId":"TYRCC"},{"dapssco_Id":"HFGHDD","uoc_GroupId":"TYRCC"}];
			oModel.setData(dsjson,false);
			oModel.setDefaultBindingMode("OneWay");
			sap.ui.getCore().setModel(oModel,"overviewModel");
			
			
			if(myapp.getDetailPage(viewName) === null){
				var newPage = sap.app.viewCache.get(viewName);
				myapp.addDetailPage(newPage);
			} 
			myapp.to(viewName, "slide");
			return;
			break;
			
		case 'RoleAssingments':
			var oModel =sap.ui.getCore().getModel("overviewModel");
			if(oModel==null){
			 oModel = new sap.ui.model.json.JSONModel();
			}
			serviceurl=serviceurl+"roleassingments/managed";
			var rajson =[{"individualId":"GHGHG","roleId":"JHGG"},{"individualId":"GHGHG","roleId":"JHGG"},{"individualId":"GHGHG","roleId":"JHGG"}];
			oModel.setData(rajson,false);
			oModel.setDefaultBindingMode("OneWay");
			sap.ui.getCore().setModel(oModel,"overviewModel");
			
			
			if(myapp.getDetailPage(viewName) === null){
				var newPage = sap.app.viewCache.get(viewName);
				myapp.addDetailPage(newPage);
			} 
			myapp.to(viewName, "slide");
			return;
			break;
			
			
		case 'UocGroupMembers':
			var oModel =sap.ui.getCore().getModel("overviewModel");
			if(oModel==null){
			 oModel = new sap.ui.model.json.JSONModel();
			}
			serviceurl=serviceurl+"uocgroupmembers/managed";
			var ugmson =[{"uoc_GroupId":"UOC123","uoc_Id":"UOCG2344"},{"uoc_GroupId":"UOC123","uoc_Id":"UOCG2344"},{"uoc_GroupId":"UOC123","uoc_Id":"UOCG2344"},{"uoc_GroupId":"UOC123","uoc_Id":"UOCG2344"}];
			oModel.setData(ugmson,false);
			oModel.setDefaultBindingMode("OneWay");
			sap.ui.getCore().setModel(oModel,"overviewModel");
			
			
			if(myapp.getDetailPage(viewName) === null){
				var newPage = sap.app.viewCache.get(viewName);
				myapp.addDetailPage(newPage);
			} 
			myapp.to(viewName, "slide");
			return;
			break;
			
		case 'SurveyAnswer':
			var oModel =sap.ui.getCore().getModel("overviewModel");
			if(oModel==null){
			 oModel = new sap.ui.model.json.JSONModel();
			}
			serviceurl=serviceurl+"surveyanswer/managed";
			var individualjson =[{"uoc_QuestionId":"RDB123","surveyId":"xxxx","value":"GHGJ","answeredAt":"10/1/14"},{"uoc_QuestionId":"RDB123","surveyId":"xxxx","value":"GHGJ","answeredAt":"10/1/14"},{"uoc_QuestionId":"RDB123","surveyId":"xxxx","value":"GHGJ","answeredAt":"10/1/14"},{"uoc_QuestionId":"RDB123","surveyId":"xxxx","value":"GHGJ","answeredAt":"10/1/14"}];
			oModel.setData(individualjson,false);
			oModel.setDefaultBindingMode("OneWay");
			sap.ui.getCore().setModel(oModel,"overviewModel");
			
			
			if(myapp.getDetailPage(viewName) === null){
				var newPage = sap.app.viewCache.get(viewName);
				myapp.addDetailPage(newPage);
			} 
			myapp.to(viewName, "slide");
			return;
			break;
			
		case 'UocQuestion':
			var oModel =sap.ui.getCore().getModel("overviewModel");
			if(oModel==null){
			 oModel = new sap.ui.model.json.JSONModel();
			}
			serviceurl=serviceurl+"surveyanswer/managed";
			var individualjson =[{"id":"RDBSHJH","uoc_Id":"UOC123","questionId":"QOC67776"},{"id":"RDBSHJH","uoc_Id":"UOC123","questionId":"QOC67776"},{"id":"RDBSHJH","uoc_Id":"UOC123","questionId":"QOC67776"},{"id":"RDBSHJH","uoc_Id":"UOC123","questionId":"QOC67776"}];
			oModel.setData(individualjson,false);
			oModel.setDefaultBindingMode("OneWay");
			sap.ui.getCore().setModel(oModel,"overviewModel");
			
			
			if(myapp.getDetailPage(viewName) === null){
				var newPage = sap.app.viewCache.get(viewName);
				myapp.addDetailPage(newPage);
			} 
			myapp.to(viewName, "slide");
			return;
			break;
			
		case 'UocGroup':
			var oModel =sap.ui.getCore().getModel("overviewModel");
			if(oModel==null){
			 oModel = new sap.ui.model.json.JSONModel();
			}
			serviceurl=serviceurl+"uocgroup/managed";
			var individualjson =[{"id":"RDVHHJ","notes":"HNBD","needId":"HJHJ3434","pathwayId":"PTH5454"},{"id":"RDVHHJ","notes":"HNBD","needId":"HJHJ3434","pathwayId":"PTH5454"},{"id":"RDVHHJ","notes":"HNBD","needId":"HJHJ3434","pathwayId":"PTH5454"}];
			oModel.setData(individualjson,false);
			oModel.setDefaultBindingMode("OneWay");
			sap.ui.getCore().setModel(oModel,"overviewModel");
			
			
			if(myapp.getDetailPage(viewName) === null){
				var newPage = sap.app.viewCache.get(viewName);
				myapp.addDetailPage(newPage);
			} 
			myapp.to(viewName, "slide");
			return;
			break;
			
			
		default:
			break;
		}
		var oModel =sap.ui.getCore().getModel("overviewModel");
		if(oModel==null){
		 oModel = new sap.ui.model.json.JSONModel();
		}
		if(sap.app.config.useLocalData == false)
        {
	    	$.ajax(
	    	{ 
				 type: 'GET', 
				 url: serviceurl,
				 crossDomain: false,
				 cache: false,
				 contentType: "application/json; charset=utf-8",
				 
				 beforeSend: function( xhr ){
					var bytes = Crypto.charenc.Binary.stringToBytes("bmays1"+ ":"+"sap");
					var base64 = Crypto.util.bytesToBase64(bytes);
						xhr.setRequestHeader("Authorization", "Basic "+base64);
						return;
					},			 
				 success: function(data) {
					 debugger;
						oModel.setData(data,false);
						oModel.setDefaultBindingMode("OneWay");
						sap.ui.getCore().setModel(oModel,"overviewModel");
						
						
						if(myapp.getDetailPage(viewName) === null){
							var newPage = sap.app.viewCache.get(viewName);
							myapp.addDetailPage(newPage);
						} 
						myapp.to(viewName, "slide");
					 
				 }, 
				 error : function (e, textStatus,errorThrown ){ alert ("error in ajax call"+":::" + e.message+ errorThrown+":::" +textStatus);}
			});
        
        }
        
		
		
		
	},
	serviceCallforSaveEditRecrod : function(viewName,myapp){
		var serviceurl =sap.app.config.hostName+":"+sap.app.config.hostPort+"/"+sap.app.config.applicationContextPath+"/";
		
		var oModel =sap.ui.getCore().getModel("transientModel").oData;
		switch (viewName) {
		case 'Need':
		
			serviceurl=serviceurl+"need/managed";
			break;
		case 'Role':

			serviceurl=serviceurl+"role/edit/"+oModel.id;
			break;
		case 'Claim':

			serviceurl=serviceurl+"claim/edit/"+oModel.id;
			break;
		case 'ClaimAssingments':

			serviceurl=serviceurl+"claimassingments/edit/"+oModel.id;
			break;
		case 'Dapssco':

			serviceurl=serviceurl+"dappsco/edit/"+oModel.id;
			break;
			
		default:
			break;
		}		
		if(sap.app.config.useLocalData == false)
        { 
	    	$.ajax(
	    	{ 
				 type: 'POST', 
				 url: serviceurl,
				 crossDomain: false,
				 cache: false,
				 contentType: "json",
				 data:oModel,
				 beforeSend: function( xhr ){
					var bytes = Crypto.charenc.Binary.stringToBytes("bmays1"+ ":"+"sap");
					var base64 = Crypto.util.bytesToBase64(bytes);
						xhr.setRequestHeader("Authorization", "Basic "+base64);
						return;
					},			 
				 success: function(data) {
					 debugger;
					 sap.m.MessageToast.show("Record have been successfully updated");
						var bus = sap.ui.getCore().getEventBus();
						bus.publish("nav","to",{id : viewName,	});
				 }, 
				 error : function (e, textStatus,errorThrown ){ alert ("error in ajax call"+":::" + e.message+ errorThrown+":::" +textStatus);}
			});
        
        }
        
		
		
		
	},
	serviceCallforSaveNewRecord : function(viewName,myapp){
		var serviceurl =sap.app.config.hostName+":"+sap.app.config.hostPort+"/"+sap.app.config.applicationContextPath;
		
		var oModel =sap.ui.getCore().getModel("transientModel").oData;
		switch (viewName) {
		case 'Need':
		
			serviceurl=serviceurl+"need/create/";
			break;
		case 'Role':

			serviceurl=serviceurl+"role/create/";
			break;
		case 'Claim':

			serviceurl=serviceurl+"claim/create/";
			break;
		case 'Dapssco':

			serviceurl=serviceurl+"dapssco/create/";
			break;
		default:
			break;
		}
		
		if(sap.app.config.useLocalData == false)
        {
	    	$.ajax(
	    	{ 
				 type: 'POST', 
				 url: serviceurl,
				 crossDomain: false,
				 cache: false,
				 contentType: "json",
				 data:oModel,
				 beforeSend: function( xhr ){
					var bytes = Crypto.charenc.Binary.stringToBytes("bmays1"+ ":"+"sap");
					var base64 = Crypto.util.bytesToBase64(bytes);
						xhr.setRequestHeader("Authorization", "Basic "+base64);
						return;
					},			 
				 success: function(data) {
					 debugger;
					 sap.m.MessageToast.show("New record have been saved updated");
						var bus = sap.ui.getCore().getEventBus();
						bus.publish("nav","to",{id : viewName,	});
					 
				 }, 
				 error : function (e, textStatus,errorThrown ){ alert ("error in ajax call"+":::" + e.message+ errorThrown+":::" +textStatus);}
			});
        
        }
        
		
		
		
	},
	
	serviceCallforDeleteRecord : function(viewName,myapp){
		var serviceurl =sap.app.config.hostName+":"+sap.app.config.hostPort+"/"+sap.app.config.applicationContextPath+"/";
		
		var oModel =sap.ui.getCore().getModel("transientModel").oData;
		switch (viewName) {
		case 'Need':
		
			serviceurl=serviceurl+"need/delete/"+oModel.id;
		case 'Role':

			serviceurl=serviceurl+"role/delete/"+oModel.id;
			break;
		case 'Claim':

			serviceurl=serviceurl+"claim/delete/"+oModel.id;
			break;
		case 'Dapssco':

			serviceurl=serviceurl+"dapssco/delete/"+oModel.id;
			break;
		default:
			break;
		}
		
		if(sap.app.config.useLocalData == false)
        {
	    	$.ajax(
	    	{ 
				 type: 'GET', 
				 url: serviceurl,
				 crossDomain: false,
				 cache: false,
				 contentType: "json",
				// data:oModel,
				 beforeSend: function( xhr ){
					var bytes = Crypto.charenc.Binary.stringToBytes("bmays1"+ ":"+"sap");
					var base64 = Crypto.util.bytesToBase64(bytes);
						xhr.setRequestHeader("Authorization", "Basic "+base64);
						return;
					},			 
				 success: function(data) {
					 debugger;
					 sap.m.MessageToast.show("record have been successfully deleted");
						var bus = sap.ui.getCore().getEventBus();
						bus.publish("nav","to",{id : viewName,	});
					 
				 }, 
				 error : function (e, textStatus,errorThrown ){ alert ("error in ajax call"+":::" + e.message+ errorThrown+":::" +textStatus);}
			});
        
        }
        
		
		
		
	}

/**
* Similar to onAfterRendering, but this hook is invoked before the controller's View is re-rendered
* (NOT before the first rendering! onInit() is used for that one!).
* @memberOf skillsurvey-ui.app
*/
//	onBeforeRendering: function() {
//
//	},

/**
* Called when the View has been rendered (so its HTML is part of the document). Post-rendering manipulations of the HTML could be done here.
* This hook is the same one that SAPUI5 controls get after being rendered.
* @memberOf skillsurvey-ui.app
*/
//	onAfterRendering: function() {
//
//	},

/**
* Called when the Controller is destroyed. Use this one to free resources and finalize activities.
* @memberOf skillsurvey-ui.app
*/
//	onExit: function() {
//
//	}

});