<template>
    <div id="article_title-component-vue">
        <VueTitle :title-data="titleData"></VueTitle>
        <VueDescription :description-data="descriptionData"></VueDescription>
        <VueLink :link-data="linkData"></VueLink>
    </div>
</template>

<script>
export default {
    components: {
        VueTitle: () =>
            import(
                /* webpackChunkName: "ArticleTitle" */ "./v-components/title/Title"
            ),
        VueDescription: () =>
            import(
                /* webpackChunkName: "ArticleTitle" */ "./v-components/description/Description"
            ),
        VueLink: () =>
            import(
                /* webpackChunkName: "ArticleTitle" */ "./v-components/link/Link"
            ),
    },
    props: {
        title: {
            type: String,
            required: false,
        },
        titleDescription: {
            type: String,
            required: false,
        },
        descriptionLink: {
            type: String,
            required: false,
        },
        linkTo: {
            type: String,
            required: false,
        },
        linkUrlTarget: {
            type: String,
            required: false,
        },
    },
    computed: {
        titleData() {
            return {
                title: this.$props.title,
            };
        },
        descriptionData() {
            return {
                titleDescription: this.$props.titleDescription,
            };
        },
        linkData() {
            return {
                descriptionLink: this.$props.descriptionLink,
                linkTo: this.$props.linkTo,
                linkUrlTarget: this.$props.linkUrlTarget,
            };
        },
    },
};
</script>