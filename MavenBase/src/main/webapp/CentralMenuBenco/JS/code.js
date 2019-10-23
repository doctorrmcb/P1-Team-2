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
    notification(4);
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