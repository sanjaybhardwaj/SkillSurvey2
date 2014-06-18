sap.ui.jsview("skillsurvey-ui.DapsscoSkills", {

	/** Specifies the Controller belonging to this View. 
	* In the case that it is not implemented, or that "null" is returned, this View does not have a Controller.
	* @memberOf level.LevelTest
	*/ 
	getControllerName : function() {
		return "skillsurvey-ui.DapsscoSkills";
	},

	/** Is initially called once after the Controller has been instantiated. It is the place where the UI is constructed. 
	* Since the Controller is given to this method, its event handlers can be attached right away. 
	* @memberOf level.LevelTest
	*/ 
	createContent : function(oController) {

		var oTable = new sap.m.Table( {
	     	
			growing : false,
			growingThreshold: 2,
			inset : false,
		//	mode: "MultiSelect",
			showUnread : true,
			growingScrollToLoad : false,
			//headerText : "Items (5)",
			headerToolbar : new sap.m.Toolbar({
				content : [
					
					new sap.m.ToolbarSpacer(),
					new sap.m.Button({
						icon: "sap-icon://create",
						//enabled:"{auth>/action/isCreate}",
						press : function() {
							oController.handleCreate();
						}
					})
				]
			}),
			selectionChange : function(e) {
				jQuery.sap.log.info("selectionChanged", Date.now());
			},
			itemPress : function(e) {
				//jQuery.sap.log.info("itemPressed", e.getParameter("listItem").getId(), e.getParameter("srcControl").getId());
			},
			updateStarted : function(e) {
				//jQuery.sap.log.info("updateStarted ", JSON.stringify(e.getParameters()), Date.now());
			},
			updateFinished : function(e) {
				//jQuery.sap.log.info("updateFinished ", JSON.stringify(e.getParameters()), Date.now());
			},
			columns : [
				new sap.m.Column({
					hAlign : "Left",
					width : "15%",
					header : new sap.m.Label({
						text : "Dapssco_Id"
					}),
					demandPopin : true
				}),
			new sap.m.Column({
					hAlign : "Left",
					width : "20%",
					header : new sap.m.Label({
						text : "Uoc_GroupId"
					}),
					demandPopin : true
				}),
				
				new sap.m.Column({
					hAlign : "Center",
					width : "4%",
				}),
				new sap.m.Column({
					hAlign : "Center",
					width : "4%",
				}),
				new sap.m.Column({
					hAlign : "Center",
					width : "4%",
				})
				
			]
	
	});
     var template = new sap.m.ColumnListItem({
				//type : "Navigation",
				unread : false,
				//vAlign : "Middle",
				cells : [
							new sap.m.Label({
								text : "{dapssco_Id}",
							}),
							 new sap.m.Label({
								text: "{uoc_GroupId}"
							}),
		                      new sap.m.Button({
								width:"8px",
								icon : "sap-icon://hint",
								enabled:"{auth>/action/isRead}",
								press:function(evt){	
									oController.handleOverview(this.getBindingContext().getObject());
								}
							}),
		                     new sap.m.Button({
								text: "Edit",
								width:"8px",
								icon : "sap-icon://edit",
								//enabled:"{auth>/action/isEdit}",
								press:function(evt){
									oController.handleEdit(this.getBindingContext().getObject());
								}
							}),
		                       new sap.m.Button({
								//enabled:"{auth>/action/isDelete}",
								icon : "sap-icon://delete",
								press:function(evt){
									oController.handleDelete(this.getBindingContext().getObject());
								}
							})
				]
			});
 
     debugger;
     var  temp = sap.ui.getCore().getModel("overviewModel");
     
			oTable.setModel(sap.ui.getCore().getModel("overviewModel"));
			oTable.bindAggregation("items", "/", template);
	

		var oControls = [];
		var iconBar = new sap.m.IconTabBar({
			id : this.createId("detail-tabs"),
			expanded : "{device>isNoPhone}",
			content : oTable
		});

		oControls.push(iconBar);
		return new sap.m.Page({
			title : "{i18n>DetailTitle}",
			showNavButton : "{device>/isPhone}",
			content : oControls,
			footer : new sap.m.Bar({
				id : this.createId("detail-footer"),
			})
		});

		
		
	}

});
