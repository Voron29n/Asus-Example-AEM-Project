<template>
    <div>
        <v-language
            :language-data="languageData"
        ></v-language>
    </div>
</template>

<script>
import LanguageComponent from "./v-components/language";

export default {
    components: {
        "v-language": LanguageComponent,
    },
    props: {
        descriptionLink: {
            type: String,
            required: false
        },
        linkTo: {
            type: String,
            required: false
        },
        linkUrlTarget: {
            type: String,
            required: false
        },
        fileReference: {
            type: String,
            required: false
        }
    },
    computed: {
        languageData(){
            return {
                descriptionLink: this.$props.descriptionLink,
                linkTo: this.$props.linkTo,
                linkUrlTarget: this.$props.linkUrlTarget,
                fileReference: this.$props.fileReference
            }
        }
    }
};
</script>