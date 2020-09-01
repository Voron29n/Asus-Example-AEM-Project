export function cmp(value) {
    return components[value];
}

let components = {
    'header': require('./cmp/vue-footer-data.js'),
    'vue-footer-data': require('./cmp/vue-footer-data.js'),
};