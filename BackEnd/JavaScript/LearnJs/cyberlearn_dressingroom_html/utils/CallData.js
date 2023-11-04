function CallData(){
    this.getDataList = function(){
         return $.getJSON("./../data/Data.json");
    }
    
}