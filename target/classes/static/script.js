
function openCreateModal() {
    document.getElementById('formModal').classList.remove('hidden');
}

function closeCreateModal() {
    document.getElementById('formModal').classList.add('hidden');
}


function openUpdateModal() {
    document.getElementById('formUpdateModal').classList.remove('hidden');
}

function closeUpdateModal() {
    document.getElementById('formUpdateModal').classList.add('hidden');
}


function saveAutor() {
    const nombreCompleto = document.getElementById('nombreCompleto').value;
    const autor = {
        nombreCompleto: nombreCompleto
    };

    fetch('/api/autores', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(autor)
    })
        .then(response => response.json())
        .then(data => {
            console.log('Autor creado:', data);
            closeCreateModal();
            window.location.reload();
        })

        .catch(error => {
            console.error('Error:', error);
        });
}


function deleteAutor() {

    const idAutorElement = document.getElementById('idAutor');
    const idAutorValue = idAutorElement.textContent;
    console.log(idAutorValue);
    fetch(`/api/autores/${idAutorValue}`, {
        method: 'DELETE'
    })
        .then(data => {
            console.log('Autor eliminado:', data);
            window.location.reload();
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

function updateAutor() {
    const idAutorElement = document.getElementById('idAutor');
    const idAutorValue = idAutorElement.textContent;
    
    // Obtener el valor actualizado del campo nombreCompleto
    const nombreAActualizar = document.getElementById('nombreAActualizar').value;

    const autor = {
        nombreCompleto: nombreAActualizar
    };

    fetch(`/api/autores/${idAutorValue}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(autor)
    })
    .then(response => response.json())
    .then(data => {
        console.log('Autor actualizado:', data);
        closeUpdateModal(); // Opcional: cierra el modal después de la actualización
        window.location.reload();
    })
    .catch(error => {
        console.error('Error:', error);
    });
}

