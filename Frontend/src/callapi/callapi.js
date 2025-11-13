import axios from "axios";



export const callapi=axios.create({
    baseURL:`http://localhost:8080/api`,
})
