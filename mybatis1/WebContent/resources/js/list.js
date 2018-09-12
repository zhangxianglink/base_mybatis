function deleteAll(basePath) {
	$("#mainForm").attr("action",basePath+"deleteAll.action");
	$("#mainForm").submit();
}