function onValueSelect(event,response,selectedPhone){
   
let lstModal = getModelList(response);

  renderModals(lstModal,selectedPhone);

}
function httpGet(theUrl)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", theUrl, false ); // false for synchronous request
    xmlHttp.send( null );
    document.getElementById('data').innerHTML = xmlHttp.responseText

    
return xmlHttp.responseText;
}
function renderModals(lstModal,selectedPhone) {
   let listModal = [];
console.log(lstModal);
 //  lstModal = JSON.parse(lstModal)

    for (let i = 0; i < lstModal.length; i++) {
        if(lstModal[i].includes(selectedPhone)){
            listModal.push(lstModal[i]);
        }
    }

    const element = document.getElementById("mySelect");
    if(element){
        element.remove();
    }
  var myParent = document.body;

  //Create array of options to be added
  var array = listModal;
  //Create and append select list
  var selectList = document.createElement("select");
  selectList.id = "mySelect";
  myParent.appendChild(selectList);

  //Create and append the options
  for (var i = 0; i < array.length; i++) {
    var option = document.createElement("option");
    option.value = array[i];
    option.text = array[i];
    selectList.appendChild(option);
  }
onModalSelect(selectedPhone);
}
function getModelList(data) {
data = JSON.parse(data);
  var lstModels = [];

  data.forEach(function (item, index) {
  console.log(item, index);
});
  for (let i = 0; i < data.length; i++) {
console.log(data);
console.log(data[i]);
    lstModels[i] = data[i].title;
  }
  return lstModels;
}
function onModalSelect(selectedPhone){
    document.getElementById("mySelect").addEventListener("change", function(event){
        onModalChange(event, selectedPhone);
      });
}
function fetchData(){
    let theUrl = 'http://localhost:8083/getAllPhone';
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", theUrl, false); // false for synchronous request
    xmlHttp.send(null);
console.log(xmlHttp.responseText);
    return xmlHttp.responseText;

}

function onModalChange(event, selectedPhone){
    var e = document.getElementById("mySelect");
      var modal = e.options[e.selectedIndex].text;
      console.log(selectedPhone);
      var url = 'http://localhost:8083/getPhoneInfoWithCered?brand='+selectedPhone+'&model='+modal;
      var xmlHttp = new XMLHttpRequest();
      xmlHttp.open("GET", url, false); // false for synchronous request
      xmlHttp.send(null);
      document.getElementById("data").innerHTML = xmlHttp.responseText;
}