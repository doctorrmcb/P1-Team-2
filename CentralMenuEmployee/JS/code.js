function goToCreatePageFromMenu() {
    location.replace(href = 'CreateReimbursementForm/create_reimbursement_form.html');
};

function goToViewManageFromMenu() {
    location.replace(href = 'ViewEditDeleteReimbursementForm/view_manage_reimbursement.html');
};

function LogoutFromMenu() {
    location.replace(href = 'Login/login.html');
};

function LogoutFromCreationForm() {
    location.replace(href = '../Login/login.html');
};

function goFromPageToMenu() {
    location.replace(href = '../central_menu_employee.html');
};

function deleteRow(r) {
    let i = r.parentNode.parentNode.rowIndex;
    document.getElementById("myTable").deleteRow(i);
}