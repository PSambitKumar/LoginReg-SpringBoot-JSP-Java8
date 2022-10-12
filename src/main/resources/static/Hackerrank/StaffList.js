class StaffList{
    constructor(){
        this.staffList = [];
        this.staffMap = new Map();
    }

    add(name, age){
        if(age > 20){
            this.staffList.push({name, age});
            this.staffMap.set(name, age);
            return true;
        }
        throw new Error("Staff member age must be greater than 20");
    }

    remove(name){
        let index = this.staffList.findIndex((staff) => staff.name === name);
        if(index !== -1){
            this.staffList.splice(index, 1);
            this.staffMap.delete(name);
            return true;
        }
        return false;
    }

    getSize(){
        return this.staffList.length;
    }
}



