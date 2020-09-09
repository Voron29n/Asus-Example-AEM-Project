<template>
    <div id="article_text-component-vue">
        <VueTitle :title-data="titleData"></VueTitle>
        <VueDescription :description-data="descriptionData"></VueDescription>
    </div>
</template>

<script>
export default {
    components: {
        VueTitle: () =>
            import(
                /* webpackChunkName: "ArticleText" */ "./v-components/title/Title"
            ),
        VueDescription: () =>
            import(
                /* webpackChunkName: "ArticleText" */ "./v-components/description/Description"
            ),
    },
    props: {
        textTitle: {
            type: String,
            required: false,
        },
        textDescription: {
            type: String,
            required: false,
        },
    },
    computed: {
        titleData() {
            return {
                textTitle: this.$props.textTitle,
            };
        },
        descriptionData() {
            return {
                textDescription: this.$props.textDescription,
            };
        },
    },
};
</script>