<template>
<div id="footer-component-vue">
        <h1>FOOTER</h1>
        <v-language
            :language-data="languageData"
        >
         </v-language>
        <v-linksGroup
            :links-group-data="linksGroupData"
        >
         </v-linksGroup>
</div>
</template>

<script>
import LanguageData from './v-components/language/Language'
import LinksGroupData from './v-components/linksGroup/LinksGroup'

export default {
    components: {
        "v-language": LanguageData,
        "v-linksGroup": LinksGroupData,
    },
    props: {
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
        fileReference: {
            type: String,
            required: false,
        },
        linksGroup: {
            type: String,
            required: false,
        },
    },
    computed: {
        languageData() {
            return {
                descriptionLink: this.$props.descriptionLink,
                linkTo: this.$props.linkTo,
                linkUrlTarget: this.$props.linkUrlTarget,
                fileReference: this.$props.fileReference,
            };
        },
        linksGroupData() {
            return {
                linksGroup: JSON.parse(this.$props.linksGroup),
            };
        },
    },
};


</script>

<style lang="scss" scoped>
@import "./v-style/footer_default";
@import "./v-style/footer_media";
</style>