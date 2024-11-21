document.addEventListener("DOMContentLoaded", async () => {
    const apiUrl = 'http://localhost:8080/api/animales';
    let currentPage = 0; // Página inicial
    const pageSize = 12; // Número de animales por página

    // Función para obtener datos de la API
    const fetchData = async (page = 0, size = 12) => {
        const response = await fetch(`${apiUrl}?page=${page}&size=${size}`);
        if (!response.ok) throw new Error("Error al obtener los animales");
        return await response.json(); // Devuelve los datos de la página
    };

    // Función para renderizar los animales
    const renderAnimales = (animales) => {
        const contenedor = document.querySelector('.animales');
        contenedor.innerHTML = ''; // Limpiar contenedor

        const fragment = document.createDocumentFragment();
        animales.forEach(animal => {
            const tarjeta = document.createElement('a');
            tarjeta.classList.add('animal-card');
            tarjeta.href = `/Frontend/html/animal.html?id=${animal.idAnimal}`;
            tarjeta.innerHTML = `
                <img class="img-animal" src="${animal.imgFondo || '/default.jpg'}" alt="${animal.nomCom}">
                <h3>${animal.nomCom}</h3>
                <h5>${animal.nomCie}</h5>
                <p>${animal.regiones || 'Región no especificada'}</p>`;
            fragment.appendChild(tarjeta);
        });
        contenedor.appendChild(fragment); // Agregar animales al DOM
    };

    // Función para manejar la paginación
    const renderPagination = (currentPage, totalPages) => {
        const prevButton = document.getElementById("prevPage");
        const nextButton = document.getElementById("nextPage");
        const pageInfo = document.getElementById("pageInfo");

        prevButton.disabled = currentPage === 0;
        nextButton.disabled = currentPage >= totalPages - 1;
        pageInfo.textContent = `Página ${currentPage + 1} de ${totalPages}`;
    };

    // Cargar la página actual
    const loadPage = async (page) => {
        try {
            const data = await fetchData(page, pageSize);
            renderAnimales(data.content); // `content` contiene los animales de la página actual
            renderPagination(page, data.totalPages);
        } catch (error) {
            console.error("Error al cargar los animales:", error);
        }
    };

    // Listeners para los botones de paginación
    document.getElementById("prevPage").addEventListener("click", () => {
        if (currentPage > 0) {
            currentPage--;
            loadPage(currentPage);
        }
    });

    document.getElementById("nextPage").addEventListener("click", () => {
        currentPage++;
        loadPage(currentPage);
    });

    // Cargar la primera página
    loadPage(currentPage);
});
