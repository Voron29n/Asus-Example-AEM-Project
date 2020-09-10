<template>
    <div id="proart__categoriesNav">
        <VueTitle :title-data="titleData"></VueTitle>
        <VueCategories :categories-data="categoriesData"></VueCategories>
    </div>
</template>

<script>
export default {
    components: {
        VueTitle: () =>
            import(
                /* webpackChunkName: "ProArtCategoriesNav" */ "./v-components/title/Title"
            ),
        VueCategories: () =>
            import(
                /* webpackChunkName: "ProArtCategoriesNav" */ "./v-components/categories/Categories"
            ),
    },
    props: {
        categoriesTitle: {
            type: String,
            required: false,
        },
        categoriesNav: {
            type: String,
            required: false,
        },
    },
    computed: {
        titleData() {
            return {
                categoriesTitle: this.$props.categoriesTitle,
            };
        },
        categoriesData() {
            return {
                categoriesNav: JSON.parse(this.$props.categoriesNav),
            };
        },
    },
};

import (/* webpackChunkName: "ProArtCategoriesNav" */ './v-style/_categories_nav_default.scss');
import (/* webpackChunkName: "ProArtCategoriesNav" */ './v-style/_categories_nav_media.scss');
</script>
