const frm_profile = document.getElementById("frm_profile");
const btn_crear_perfil = document.getElementById("btn_crear_perfil");

btn_crear_perfil.addEventListener("click", e => {
    if (frm_profile.checkValidity() === false) {
        event.preventDefault();
        event.stopPropagation();
    }
    frm_profile.classList.add('was-validated');
});

const container_ciudad = document.getElementById("container_ciudad");
const select_country = document.getElementById("pais");
const select_city = document.getElementById("ciudad");
select_country.addEventListener("change", e => {
    const value = e.target.value;
    const url = `/city/country/${value}`

    fetch(url)
        .then(r => r.json())
        .then(cities => {
            let options = `<option value="">Seleccione una ciudad</option>`;
            cities.forEach(city => {
                options += `<option value="${city.name}">${city.name}</option>`;
            });
            select_city.innerHTML = options;
        });

    container_ciudad.removeAttribute("style");
});
