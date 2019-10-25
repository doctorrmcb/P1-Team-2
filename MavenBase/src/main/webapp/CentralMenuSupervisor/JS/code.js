function goToCreatePageFromMenu() {
    location.replace(href = 'CreateReimbursementForm/create_reimbursement_form.html');
};

function goToViewManageFromMenu() {
    location.replace(href = 'ViewEditDeleteReimbursementForm/view_manage_reimbursement.html');
};

function goToUpdateForm() {
    location.replace(href = '../UpdatePendingReimbursementForm/Update_Pending_Form.html');
};

function approveRequest(r) {
    let i = r.parentNode.parentNode.rowIndex;
    document.getElementById("myTable").deleteRow(i);
};

function goToDirectSupervisorPrivilege() {
    location.replace(href = 'DirectSupervisorPrivilegeForm/DirectSupervisorPrivilegeForm.html');
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
    location.replace(href = '../central_menu_Supervisor.html');
};

function goFromLogintoMainMenu() {
    location.replace(href = 'CentralMenuSupervisor/central_menu_Supervisor.html');
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
        constructor(initialInputId, reimbursementId, eventDate, location, description, cost, evaluationFormatId, justification, eventFileName, eventAttachment, approvalFileName, approvalAttachment, timeOutStart, timeOutEnd, addInfo) {
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
            this.addInfo = addInfo;
        }
    }

    class Reimbursement {
        constructor(reimbursementId, employeeId, approvalId, initialInputId, evaluationId, eventTypeId, status) {
            this.reimbursementId = reimbursementId;
            this.employeeId = employeeId;
            this.approvalId = approvalId;
            this.initialInputId = initialInputId;
            this.evaluationId = evaluationId;
            this.eventTypeId = eventTypeId;
            this.status = status;
        }
    }
    
    console.log("testSubmit called.")
    //additional info
    // New Reimbursement:
    // -create new approval id
    // -create new evaluation id and put in new evaluation object
    // -Evaluation type needed if people select other...


    // Gets the employeeId from the cookie.
    let cookie = document.cookie;
    let empId = cookie.substring(11, cookie.length);
    let eventTypeId = document.getElementById("eventTypeId").value;
    // Creates new reimId, attaches to currently signed employee, creates new appId, creates new initId, creates new evalId, sets status."
    //                                  reim emp  app init eval  event  status
    let reimbursement = new Reimbursement(1, Number(empId), 1, 1, 1, Number(eventTypeId), "Waiting for Approval");
    var xhrNewReimbursement = new XMLHttpRequest();
    xhrNewReimbursement.open("POST", "../../new-reimbursement", true);
    xhrNewReimbursement.send(JSON.stringify(reimbursement));

    xhrNewReimbursement.onreadystatechange = function() {
        if (xhrNewReimbursement.readyState === 4) {
            if (xhrNewReimbursement.status === 200) {
                // Getting updated cookies.
                let cookies = document.cookie;
                let newId = cookies.split('; ');
                newId = newId[1].substring(6, newId[1].length);
                let addInfo = document.getElementById("additionalInfo").value;
                let fileName = document.getElementById("validatedCustomFile").value;
                fileName = fileName.split('\\').pop().split('/').pop();
                let input = new InitialInput(newId, newId, document.getElementById("event-start-time").value, document.getElementById("location").value, document.getElementById("description").value, document.getElementById("cost").value, document.getElementById("evaluationFormatId").value, document.getElementById("justification").value, fileName, null, fileName, null, document.getElementById("event-start-time").value, document.getElementById("event-end-time").value, addInfo);
                // Creates InitialInput obj, Approval obj, & Evaluation obj.
                var xhrInitialInput = new XMLHttpRequest();
                xhrInitialInput.open("POST", "../../new-init-input", true); 
                xhrInitialInput.send(JSON.stringify(input));
                xhrInitialInput.onreadystatechange = function() {
                    if (xhrInitialInput.readyState === 4) {
                        if (xhrInitialInput.status === 200) {
                            let target = document.getElementById("fileId").value;
                            
                            var xhrFile = new XMLHttpRequest();
                            if (target === "1") {
                                xhrFile.open("POST", "../../new-event-file", true);
                            } else {
                                xhrFile.open("POST", "../../new-approval-file", true);
                            }
                            let file = document.getElementById("validatedCustomFile").files[0];
                            xhrFile.send(file);
                            xhrFile.onreadystatechange = function() {
                                if (xhrFile.readyState === 4) {
                                    if (xhrFile.status === 200) {
                                        submittingAfterCreation()
                                    }
                                }
                            }
                        }
                    }
                }    
            }
        }
    }
};

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


function getAllApprovals() {
//listFile.open("GET", "../../read-listReimbursementForm", true);
let myTable = document.getElementById("myTable");
let xhr = new XMLHttpRequest();
xhr.open("GET", "../../read-listReimbursementForm", true);
    xhr.send();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {  // Makes sure the document is ready to parse.
                if (xhr.status === 200) {  // Makes sure it's found the file.
                let allText = xhr.responseText;
                let readApproval = JSON.parse(allText);
                let leng = readApproval.length;
                for(let prop in readApproval) {
                console.log(readApproval[prop]);
                //approval_id, reimbursement_id, dir_sup_app, dept_head_app, ben_co_app,
                //approval_time, ben_co_alter_info, additional_info, denial_info
                let tr = document.createElement('tr');
                addCell(tr, readApproval[prop].approvalId);
                addCell(tr, readApproval[prop].reimbursementId);
                addCell(tr, readApproval[prop].dirSupApp);
                addCell(tr, readApproval[prop].deptHeadApp);
                addCell(tr, readApproval[prop].benCoApp);
                addCell(tr, readApproval[prop].approvalTime);
                addCell(tr, readApproval[prop].benCoAlterInfo);
                addCell(tr, readApproval[prop].additionalInfo);
                addCell(tr, readApproval[prop].denialInfo);
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
            }
                }
            }
        }
};