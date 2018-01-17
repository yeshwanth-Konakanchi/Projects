jQuery(document).ready(function() {
        $("#list").jqGrid({
                url : "ticketData",
                datatype : "json",
                mtype : 'POST',
                colNames : [ 'Ticket Reference No', 'Ticket Category', 'Ticket Sub-Category', 'Description', 'Status', 'Comments' ],
                colModel : [ {
                        name : 'ticketReferenceNo',
                        index : 'ticketReferenceNo',
                        width : 100
                }, {
                        name : 'ticketCategory',
                        index : 'ticketCategory',
                        width : 150,
                        editable : true
                }, {
                        name : 'ticketSubCategory',
                        index : 'ticketSubCategory',
                        width : 150,
                        editable : true
                }, {
                        name : 'description',
                        index : 'description',
                        width : 100,
                        editable : true
                }, {
                        name : 'status',
                        index : 'status',
                        width : 100,
                        editable : true
                }, {
                    name : 'comments',
                    index : 'comments',
                    width : 100,
                    editable : true
            } ],
                pager : '#pager',
                rowNum : 10,
                rowList : [ 10, 20, 30 ],
                sortname : 'invid',
                sortorder : 'desc',
                viewrecords : true,
                gridview : true,
                caption : 'Data Report',
                jsonReader : {
                        repeatitems : false,
                },
                editurl : "ticketData"
        });
        jQuery("#list").jqGrid('navGrid', '#pager', {
                edit : true,
                add : true,
                del : true,
                search : true
        });
});