const Accessory = require('../models/Accessory')

async function createAccessory(accessory){
    const record = new Accessory(accessory);
    return record.save();
}

async function getAllAccessories(existing){
    return Accessory.find({_id: {$nin: existing}});
}

module.exports = {
    createAccessory,
    getAllAccessories
}