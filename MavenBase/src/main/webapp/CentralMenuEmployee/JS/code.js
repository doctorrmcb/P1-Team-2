function goToCreatePageFromMenu() {
    location.replace(href = 'CreateReimbursementForm/create_reimbursement_form.html');
};

function goToViewManageFromMenu() {
    location.replace(href = 'ViewEditDeleteReimbursementForm/view_manage_reimbursement.html');
};

function goToUpdateForm() {
    location.replace(href = '../UpdatePendingReimbursementForm/Update_Pending_Form.html');
};

function goToViewForm() {
    location.replace(href = '../ViewEditDeleteReimbursementForm/view_manage_reimbursement.html');
};

function logoutFromEmployeeMenu() {
    location.replace(href = '../login.html');
};

function logoutFromCreateForm() {
    location.replace(href = '../../login.html');
};

function logoutFromViewUpdateForm() {
    location.replace(href = '../../login.html');
};

function logoutFromEditForm() {
    location.replace(href = '../..login.html');
};

function goToViewFormFromEdit() {
    location.replace(href = '../ViewEditDeleteReimbursementForm/view_manage_reimbursement.html');
};

function goFromPageToMenu() {
    location.replace(href = '../central_menu_employee.html');
};

function goFromLogintoMainMenu() {
    location.replace(href = 'CentralMenuEmployee/central_menu_employee.html');
};

function deleteRow(r) {
    let i = r.parentNode.parentNode.rowIndex;
    document.getElementById("myTable").deleteRow(i);
};


function dateDisplay() {
    var x = document.getElementById("dob").value;
    document.getElementById("demo").innerHTML = x;
};

function openNav() {
    //notification(4);
    document.getElementById("mySidebar").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
};

function closeNav() {
    document.getElementById("mySidebar").style.width = "0";
    document.getElementById("main").style.marginLeft = "0";
};

function notification(n) {
    for (let i = 0; i < n; i++) {
        createAnchor("[notification triggers onload]");
    }

};


function createAnchor(message) {
    let para = document.createElement("P");
    para.innerHTML = message;
    document.getElementById("myCreation").appendChild(para);
}


function toastSubmitted() {
    let x = document.getElementById("snackbar");
    x.className = "show";
    setTimeout(function() { x.className = x.className.replace("show", ""); }, 3000);
}

function submittingAfterCreation() {
    goToViewForm();
};

document.querySelectorAll('input[type=number]')
    .forEach(e => e.oninput = () => {
        // Always 2 digits
        if (e.value.length >= 2) e.value = e.value.slice(0, 2);
        // 0 on the left (doesn't work on FF)
        if (e.value.length === 1) e.value = '0' + e.value;
        // Avoiding letters on FF
        if (!e.value) e.value = '00';
    });

function createNewReimbursement() {
    class InitialInput {
        constructor(initialInputId, reimbursementId, eventDate, location, description, cost, evaluationFormatId, justification, eventFileName, eventAttachment, approvalFileName, approvalAttachment, timeOutStart, timeOutEnd) {
            this.initialInputId = initialInputId;
            this.reimbursementId = reimbursementId;
            this.eventDate = eventDate;
            this.location = location;
            this.description = description;
            this.cost = cost;
            this.evaluationFormatId = evaluationFormatId;
            this.justification = justification;
            this.eventFileName = eventFileName;
            this.eventAttachment = eventAttachment;
            this.approvalFileName = approvalFileName;
            this.approvalAttachment = approvalAttachment;
            this.timeOutStart = timeOutStart;
            this.timeOutEnd = timeOutEnd;
        }
    }
    console.log("testSubmit called.")
    var xhrInitialInput = new XMLHttpRequest();
    xhrInitialInput.open("POST", "../../new-reimbursement", true);
    let input = new InitialInput("1", "1", document.getElementById("event-start-time").value, document.getElementById("location").value, document.getElementById("description").value, document.getElementById("cost").value, document.getElementById("evaluationFormatId").value, document.getElementById("justification").value, document.getElementById("validatedCustomFile").value, null, document.getElementById("validatedCustomFile").value, null, document.getElementById("event-start-time").value, document.getElementById("event-end-time").value);
    xhrInitialInput.send(JSON.stringify(input));
    /* let file = document.getElementById("validatedCustomFile").files[0];
    var xhrFile = new XMLHttpRequest();
    xhrFile.open("POST", "../../new-file", true);
    xhrFile.send(file); */
}

function addCell(tr, val) {
    let td = document.createElement('td');
    td.innerHTML = val;
    tr.appendChild(td);
};


function addRow(myTable, val_1, val_2, val_3, val_4, val_5, val_6, val_7, val_8, val_9, val_10) {
    let tr = document.createElement('tr');
    addCell(tr, val_1);
    addCell(tr, val_2);
    addCell(tr, val_3);
    addCell(tr, val_4);
    addCell(tr, val_5);
    addCell(tr, val_6);
    addCell(tr, val_7);
    addCell(tr, val_8);
    addCell(tr, val_9);
    addCell(tr, val_10);
    myTable.appendChild(tr);
    let cella = tr.insertCell(tr.length);
    let btnRemovea = document.createElement("INPUT");
    btnRemovea.type = "button";
    btnRemovea.value = "Edit";
    btnRemovea.setAttribute("onclick", "goToUpdateForm();");
    cella.appendChild(btnRemovea);
    let cell = tr.insertCell(tr.length);
    let btnRemove = document.createElement("INPUT");
    btnRemove.type = "button";
    btnRemove.value = "Remove";
    btnRemove.setAttribute("onclick", "deleteRow(this);");
    cell.appendChild(btnRemove);
};

function main() {
    let myTable = document.getElementById("myTable");
    addRow(myTable, 3, 'foo', 'bar', 'baz', 'one', 'two', 'three', 'one', 'two', 'three');
};