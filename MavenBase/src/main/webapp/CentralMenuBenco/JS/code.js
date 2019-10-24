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

function goToBencoPrivilege() {
    location.replace(href = 'BencoPrivilegeForm/BencoPrivilegeForm.html');
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
    location.replace(href = '../central_menu_Benco.html');
};

function goFromLogintoMainMenu() {
    location.replace(href = 'CentralMenuBenco/central_menu_Benco.html');
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
    document.getElementById("mySidebar").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
};

function closeNav() {
    document.getElementById("mySidebar").style.width = "0";
    document.getElementById("main").style.marginLeft = "0";
};

function notification(n) {
    for (let i = 0; i < n; i++) {
        createAnchor("[message goes here]");
    }

};

function createAnchor(message) {
    var para = document.createElement("P");
    para.innerHTML = message;
    document.getElementById("myCreation").appendChild(para);
}

function approveRequest(r) {
    let i = r.parentNode.parentNode.rowIndex;
    document.getElementById("myTable").deleteRow(i);
};

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
    let testData = document.getElementById("form1");
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "../../new-reimbursement", true);
    let input = new InitialInput("1", "1", document.getElementById("event-start-time").value, document.getElementById("location").value, document.getElementById("description").value, document.getElementById("cost").value, document.getElementById("evaluationFormatId").value, document.getElementById("justification").value, document.getElementById("validatedCustomFile").value, "file", document.getElementById("validatedCustomFile").value, "file", document.getElementById("event-start-time").value, document.getElementById("event-end-time").value);
    xhr.send(
        JSON.stringify(input)
    );
}


function addCell(tr, val) {
    let td = document.createElement('td');
    td.innerHTML = val;
    tr.appendChild(td);
};

function printApprovalTable() {
let tr = document.createElement('tr');
let myTable = document.getElementById("myTable");
    let txtFile = new XMLHttpRequest();
    txtFile.open("GET", "../../read-reimbursementForm", true);
    txtFile.send();
    txtFile.onreadystatechange = function() {
        if (txtFile.readyState === 4) {  // Makes sure the document is ready to parse.
                if (txtFile.status === 200) {  // Makes sure it's found the file.
                allText = txtFile.responseText;
                readApproval = JSON.parse(allText);
                for(let prop in readApproval) {
                addCell(tr, readApproval[prop]);
                 //console.log(readApproval[prop]);
                }
                }
        }
    }

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