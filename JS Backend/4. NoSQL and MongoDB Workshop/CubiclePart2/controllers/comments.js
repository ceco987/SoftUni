module.exports = {
    async post(req, res) {
        const cubeId = req.params.cubeId;
        const comment = {
            author: req.body.author,
            comment: req.body.comment
        }

        await req.storage.createComment(cubeId, comment);

        res.redirect(`/details/${cubeId}`)
    }
}