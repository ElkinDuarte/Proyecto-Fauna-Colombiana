document.addEventListener("DOMContentLoaded", async () => {
    const params = new URLSearchParams(window.location.search);
    const idAnimal = params.get('id');

    if (!idAnimal) {
        console.error("No se encontró el ID del animal en la URL.");
        return;
    }

    try {
        // Llamada al API con el ID del animal
        const response = await fetch(`http://localhost:8080/api/animales/${idAnimal}`);
        if (!response.ok) throw new Error("Error al obtener el animal");

        const animal = await response.json();

        // Actualizar la página con los datos del animal
        document.querySelector("#animal-img").src = animal.imgFondo || '/Frontend/images/default.jpg';
        document.querySelector("#animal-nombre").textContent = animal.nomCom || "Nombre Desconocido";
        document.querySelector("#animal-nombre-cientifico").textContent = animal.nomCie || "Nombre Científico Desconocido";
        document.querySelector("#descripcion-general").textContent = animal.desGeneral || "Descripción no disponible";

        document.querySelector("#animal-tamano").textContent = animal.tamano || "-";
        document.querySelector("#animal-peso").textContent = animal.peso || "-";
        document.querySelector("#animal-coloracion").textContent = animal.coloracion || "-";
        document.querySelector("#animal-habitat").textContent = animal.habitat || "-";
        document.querySelector("#animal-dieta").textContent = animal.dieta || "-";
        document.querySelector("#animal-comportamiento").textContent = animal.comportamiento || "-";
        document.querySelector("#animal-conservacion").textContent = animal.conservacion || "-";

        // Actualizar imágenes del carrusel
        const carouselInner = document.querySelector("#carousel-inner");
        carouselInner.innerHTML = ""; // Limpiar carrusel existente

        if (animal.imgSlide && animal.imgSlide.length > 0) {
            animal.imgSlide.forEach((img, index) => {
                const slide = document.createElement("div");
                slide.className = `carousel-item ${index === 0 ? "active" : ""}`;
                slide.innerHTML = `<img src="${img}" class="d-block w-100" alt="Imagen del Animal">`;
                carouselInner.appendChild(slide);
            });
        } else {
            // Imagen por defecto si no hay carrusel
            const defaultSlide = document.createElement("div");
            defaultSlide.className = "carousel-item active";
            defaultSlide.innerHTML = `<img src="/Frontend/images/default.jpg" class="d-block w-100" alt="Imagen por defecto">`;
            carouselInner.appendChild(defaultSlide);
        }

        // Actualizar curiosidades
        const curiosidadesContainer = document.querySelector("#curiosidades-container");
        curiosidadesContainer.innerHTML = `<h3>Curiosidades del ${animal.nomCom || "Animal"}</h3>`;
        if (animal.curiosidades && animal.curiosidades.length > 0) {
            animal.curiosidades.forEach((curiosidad, index) => {
                const p = document.createElement("p");
                p.textContent = `${index + 1}. ${curiosidad}`;
                curiosidadesContainer.appendChild(p);
            });
        } else {
            const p = document.createElement("p");
            p.textContent = "No hay curiosidades disponibles para este animal.";
            curiosidadesContainer.appendChild(p);
        }

    } catch (error) {
        console.error("Error al cargar los datos del animal:", error);
    }
});
