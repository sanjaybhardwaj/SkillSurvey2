sap.ui.controller("skillsurvey-ui.SurveyAnswer", {

/**
* Called when a controller is instantiated and its View controls (if available) are already created.
* Can be used to modify the View before it is displayed, to bind event handlers and do other one-time initialization.
* @memberOf skillsurvey-ui.SurveyAnswer
*/
//	onInit: function() {
//
//	},

/**
* Similar to onAfterRendering, but this hook is invoked before the controller's View is re-rendered
* (NOT before the first rendering! onInit() is used for that one!).
* @memberOf skillsurvey-ui.SurveyAnswer
*/
//	onBeforeRendering: function() {
//
//	},

/**
* Called when the View has been rendered (so its HTML is part of the document). Post-rendering manipulations of the HTML could be done here.
* This hook is the same one that SAPUI5 controls get after being rendered.
* @memberOf skillsurvey-ui.SurveyAnswer
*/
//	onAfterRendering: function() {
//
//	},

/**
* Called when the Controller is destroyed. Use this one to free resources and finalize activities.
* @memberOf skillsurvey-ui.SurveyAnswer
*/
//	onExit: function() {
//
//	}
	
	
	createJsonString:function(isCreate,dataModel){
		var jsonString='{';
		var keys = Object.keys(dataModel).length;
		var counter=1;
		if(!isCreate){
			for(var key in dataModel){
				jsonString+='"'+key+'":"'+dataModel[key]+'"';
				if(counter<=keys-1){
					jsonString+=',';
				}
				counter+=1;
			}
			jsonString +='}';
		}else{
			for(var key in dataModel){
				jsonString+='"'+key+'":""';
				if(counter==keys-1){
					jsonString+=',';
				}
				counter+=1;
			}
			jsonString +='}';
		}
		return jsonString;
	},
	handleOverview:function(dataModel){
		var transientModel = new sap.ui.model.json.JSONModel();
		var jsonString=this.createJsonString(false, dataModel);
		transientModel.setDefaultBindingMode("TwoWay");
		transientModel.setJSON(jsonString ,false);
		sap.ui.getCore().setModel(transientModel,"transientModel");
		var bus = sap.ui.getCore().getEventBus();
		bus.publish("nav","toOverview",{id : "SurveyAnswerOverview"	});
	},
	handleEdit:function(dataModel){
		var transientModel = new sap.ui.model.json.JSONModel();
		var jsonString=this.createJsonString(false, dataModel);
		transientModel.setDefaultBindingMode("TwoWay");
		transientModel.setJSON(jsonString ,false);
		sap.ui.getCore().setModel(transientModel,"transientModel");
		var bus = sap.ui.getCore().getEventBus();
		bus.publish("nav","toEdit",{id : "SurveyAnswerEdit"	});
	},
	handleCreate:function(dataModel){
		var jsonString='{"uoc_QuestionId":"","surveyId":"","value":"","answeredAt":""}';
		var transientModel = new sap.ui.model.json.JSONModel();
		transientModel.setDefaultBindingMode("TwoWay");
		transientModel.setJSON(jsonString ,false);
		sap.ui.getCore().setModel(transientModel,"transientModel");
		var bus = sap.ui.getCore().getEventBus();
		bus.publish("nav","toCreate",{id : "SurveyAnswerCreate"	});
	},
	handleDelete:function(dataModel){
		var transientModel = new sap.ui.model.json.JSONModel();
		transientModel.setDefaultBindingMode("TwoWay");
		transientModel.setJSON(this.createJsonString(false, dataModel) ,false);
		sap.ui.getCore().setModel(transientModel,"transientModel");
		sap.m.MessageBox.confirm(
				"Do you sure want to delete!",
				function (oAction) {
					if (sap.m.MessageBox.Action.OK === oAction) {
						var bus = sap.ui.getCore().getEventBus();
						bus.publish("nav","toDelete",{id : "SurveyAnswer"});
					}
				}
		);
		
	}

});